package com.example.caree.service;
import com.example.caree.DAO.PostDao;
import com.example.caree.model.Post;
import java.util.List;

public class PostService {

    public List<Post> fetchAllPosts() {
        PostDao postDao = new PostDao();
        return postDao.fetchAll();
    }

    public Post fetchOnePost(int id) {
        PostDao postDao = new PostDao();
        return postDao.fetchOne(id);
    }

    public void createPost(Post post) {
        PostDao postDao = new PostDao();
        postDao.create(post);
    }

    public void deletePost(int id) {
        PostDao postDao = new PostDao();
        postDao.delete(id);
    }

    public void updatePost(int id, Post post) {
        PostDao postDao = new PostDao();
        postDao.update(id, post);
    }


}
