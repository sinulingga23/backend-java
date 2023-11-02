package org.sinulingga.dao;

import org.sinulingga.model.Category;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryDao {
    private Connection connection;

    public CategoryDao(Connection connection) {
        this.connection = connection;
    }

    public void add(Category category)  {
        try {
            String query = "INSERT INTO public.category (id,name, description) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, category.getId());
            preparedStatement.setString(2, category.getName());
            preparedStatement.setString(3, category.getDescription());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error at " + CategoryDao.class.getSimpleName() + ". Error: " + e.getMessage());
            e.getStackTrace();
        }
    }
}
