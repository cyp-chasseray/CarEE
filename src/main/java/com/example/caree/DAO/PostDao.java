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

public class PostDao implements GenericDAO<Post>{

    public void create(Post newPost)  {
        Connection connection = ConnectionManager.getINSTANCE();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO car (name, description, price, categoryId) VALUES (?, ?, ?, ?);");
            statement.setString(1, newPost.getTitle());
            statement.setString(2, newPost.getContent());
            statement.setDouble(3, newPost.getPrice());
            statement.setLong(4, newPost.getCategoryId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Post> fetchAll() {
        List<Post> listPost = new ArrayList<>();
        Connection connection = ConnectionManager.getINSTANCE();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, name, description, price, categoryId FROM car;");
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                listPost.add(new Post(
                        results.getLong("id"),
                        results.getString("name"),
                        results.getString("description"),
                        results.getDouble("price"),
                        results.getInt("categoryId")
                ));
            }
            return listPost;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Post fetchOne(int id) {
        Connection connection = ConnectionManager.getINSTANCE();
        Post post = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, name, description, price, categoryId FROM car WHERE id = ?;");
            statement.setInt(1, id);
            ResultSet results = statement.executeQuery();

            if (results.next()) {
                post = (new Post(
                        results.getLong("id"),
                        results.getString("name"),
                        results.getString("description"),
                        results.getDouble("price"),
                        results.getInt("categoryId")
                )
                );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return post;
    }

    @Override
    public void update(int id, Post postToUpdate) {
        Connection connection = ConnectionManager.getINSTANCE();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE car SET name = ?, description = ?, price = ?, categoryId = ? WHERE id = ?;");
            statement.setString(1, postToUpdate.getTitle());
            statement.setString(2, postToUpdate.getContent());
            statement.setDouble(3, postToUpdate.getPrice());
            statement.setInt(4, postToUpdate.getCategoryId());
            statement.setInt(5, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionManager.getINSTANCE();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM car WHERE id = ?;");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
