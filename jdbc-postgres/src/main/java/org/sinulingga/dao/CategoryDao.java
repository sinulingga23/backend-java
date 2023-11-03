package org.sinulingga.dao;

import org.sinulingga.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            e.printStackTrace();
        }
    }

    public Category findOne(String id) {
        try {
            String query = "SELECT id, name, description FROM public.category WHERE id = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getString("id"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                return category;
            }

            return null;
        } catch (SQLException e) {
            System.out.println("Error ar " + CategoryDao.class.getSimpleName() + ". Error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Category> findAll() {
        try {
            String query = "SELECT id, name, description FROM public.category";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Category> listCategory = new ArrayList<>();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getString("id"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                listCategory.add(category);
            }

            return listCategory.size() > 0 ? listCategory : null;
        } catch (SQLException e) {
            System.out.println("Error ar " + CategoryDao.class.getSimpleName() + ". Error: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public void deleteById(String id) {
        try {
            String query = "DELETE FROM public.category WHERE id = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error ar " + CategoryDao.class.getSimpleName() + ". Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
