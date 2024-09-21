package com.example.lesson5tasks.task1.studentServlet;

import com.example.lesson5tasks.task1.model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.postgresql.Driver;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "com.example.lesson5tasks.task1.studentServlet.StudentListServlet",
        urlPatterns = "/student/list")
public class StudentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jakarta?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("select * from student s order by s.id");
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student build = Student.builder()
                        .id(resultSet.getInt("id"))
                        .full_name(resultSet.getString("full_name"))
                        .create_at(resultSet.getTimestamp("create_at").toLocalDateTime())
                        .group_id(resultSet.getInt("group_id"))
                        .age(resultSet.getInt("age"))
                        .build();
                studentList.add(build);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/student/studentList.jsp");
        req.setAttribute("studentList", studentList);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
