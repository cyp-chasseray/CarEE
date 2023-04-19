package com.example.caree.DAO;

import com.example.caree.connexion.ConnectionManager;
import com.example.caree.model.Category;
import com.example.caree.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements GenericDAO<Category>{

    public void create(Category newCategory) {
        Connection connection = ConnectionManager.getINSTANCE();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO category (name) VALUES (?);");
            statement.setString(1, newCategory.getName());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> fetchAll() {
        List<Category> listCategories = new ArrayList<>();
        Connection connection = ConnectionManager.getINSTANCE();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, name FROM category;");
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                listCategories.add(new Category(
                        results.getLong("id"),
                        results.getString("name")
                ));
            }
            return listCategories;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category fetchOne(int id) {
        Connection connection = ConnectionManager.getINSTANCE();
        Category category = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, name FROM category WHERE id = ?;");
            statement.setInt(1, id);
            ResultSet results = statement.executeQuery();

            if (results.next()) {
                category = (new Category(
                        results.getLong("id"),
                        results.getString("name")
                )
                );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionManager.getINSTANCE();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM category WHERE id = ?;");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
