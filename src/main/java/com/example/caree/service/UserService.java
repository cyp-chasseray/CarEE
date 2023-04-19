package com.example.caree.service;
import com.example.caree.DAO.UserDao;
import com.example.caree.model.User;

import java.util.List;

public class UserService {

    public List<User> fetchAllUsers() {
        UserDao userDao = new UserDao();
        return userDao.fetchAll();
    }

    public User fetchOneUser(int id) {
        UserDao userDao = new UserDao();
        return userDao.fetchOne(id);
    }

    public void createUser(User user) {
        UserDao userDao = new UserDao();
        userDao.create(user);
    }

    public void deleteUser(int id) {
        UserDao userDao = new UserDao();
        userDao.delete(id);
    }

    public void updateUser(int id) {
//        UserDao userDao = new UserDao();
//        userDao.update(id);
    }
}

