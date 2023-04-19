package com.example.caree.DAO;
import com.example.caree.model.Post;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        CategoryDao categoryDao = new CategoryDao();
//        categoryDao.create("Essence");
//        UserDao userDao = new UserDao();
//        User usertest = userDao.fetchOne(1);
//        System.out.println(usertest.getUserName());
        PostDao postDao = new PostDao();
        Post post = new Post(4L, "mazda", "jolie mazda", 2535.25, 2);
        postDao.create(post);
        Post testPost = postDao.fetchOne(2);
        System.out.println(testPost.getPrice());
    }
}
