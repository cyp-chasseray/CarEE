package com.example.caree.DAO;

import com.example.caree.connexion.ConnectionManager;
import com.example.caree.model.Category;
import com.example.caree.model.Post;
import com.example.caree.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements GenericDAO<User>{

    public void create(User newUser) {
        Connection connection = ConnectionManager.getINSTANCE();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user (userName, password) VALUES (?, ?);");
            statement.setString(1, newUser.getUserName());
            statement.setString(2, newUser.getPassword());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> fetchAll() {
        List<User> listUsers = new ArrayList<>();
        Connection connection = ConnectionManager.getINSTANCE();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, userName, password FROM user;");
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                User newUser = new User(results.getString("userName"), results.getString("password"));
                newUser.setId(results.getInt("id"));
                listUsers.add(newUser);
            }
            return listUsers;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User fetchOne(int id) {
        Connection connection = ConnectionManager.getINSTANCE();
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, userName, password FROM user WHERE id = ?;");
            statement.setInt(1, id);
            ResultSet results = statement.executeQuery();

            if (results.next()) {
                user = (new User(
                        results.getString("userName"),
                        results.getString("password")
                )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User fetchOneByUserName(String userName) {
        Connection connection = ConnectionManager.getINSTANCE();
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, userName, password FROM user WHERE userName = ?;");
            statement.setString(1, userName);
            ResultSet results = statement.executeQuery();

            if (results.next()) {
                user = (new User(
                        results.getString("userName"),
                        results.getString("password")
                )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void update(int id, User user) {
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionManager.getINSTANCE();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE id = ?;");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
