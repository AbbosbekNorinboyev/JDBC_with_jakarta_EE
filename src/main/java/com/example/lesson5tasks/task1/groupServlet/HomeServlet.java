package com.example.lesson5tasks.task1.groupServlet;

import com.example.lesson5tasks.task1.model.Groups;
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

@WebServlet(name = "com.example.lesson5tasks.task1.groupServlet.HomeServlet", value = "")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Groups> groupsList = new ArrayList<>();
        try {
            DriverManager.registerDriver(new Driver());
            var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jakarta?currentSchema=public",
                    "postgres",
                    "2210");
            var statement = connection.prepareStatement("select * from groups b order by b.id;");
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Groups groups = Groups.builder()
                        .id(resultSet.getInt("id"))
                        .group_name(resultSet.getString("group_name"))
                        .create_at(resultSet.getTimestamp("create_at").toLocalDateTime())
                        .count(resultSet.getInt("count"))
                        .build();
                groupsList.add(groups);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/homes.jsp");
        req.setAttribute("groupsList", groupsList);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
