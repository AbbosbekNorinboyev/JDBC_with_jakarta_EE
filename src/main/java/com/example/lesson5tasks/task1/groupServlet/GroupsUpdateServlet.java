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

@WebServlet(name = "com.example.lesson5tasks.task1.groupServlet.GroupUpdateServlet",
        urlPatterns = "/group/update/*")
public class GroupsUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jakarta?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("select * from groups g where g.id = ?");
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Groups build = Groups.builder()
                        .id(resultSet.getInt("id"))
                        .group_name(resultSet.getString("group_name"))
                        .create_at(resultSet.getTimestamp("create_at").toLocalDateTime())
                        .count(resultSet.getInt("count"))
                        .build();
                req.setAttribute("build", build);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/group/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        String name = req.getParameter("name");
        int count = Integer.parseInt(req.getParameter("count"));
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jakarta?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("update groups g set group_name=?,count=? where g.id=?");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, count);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            resp.sendRedirect("/");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
