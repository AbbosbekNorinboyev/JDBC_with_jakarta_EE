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

@WebServlet(name = "com.example.lesson5tasks.task1.studentServlet.StudentUpdateServlet",
        urlPatterns = "/student/update/*")
public class StudentUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jakarta?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("select * from student s where s.id = ?;");
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Student build = Student.builder()
                        .id(resultSet.getInt("id"))
                        .full_name(resultSet.getString("full_name"))
                        .create_at(resultSet.getTimestamp("create_at").toLocalDateTime())
                        .group_id(resultSet.getInt("group_id"))
                        .age(resultSet.getInt("age"))
                        .build();
                req.setAttribute("build", build);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/student/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        int groupId = Integer.parseInt(req.getParameter("group_id"));
        int age = Integer.parseInt(req.getParameter("age"));
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jakarta?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("update student s set group_id = ?, age = ?  where s.id = ?;");
            preparedStatement.setInt(1, groupId);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            resp.sendRedirect("/");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
