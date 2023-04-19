package com.example.caree.servlet;
import com.example.caree.DAO.CategoryDao;
import com.example.caree.DAO.UserDao;
import com.example.caree.model.Category;
import com.example.caree.model.Post;
import com.example.caree.model.User;
import com.example.caree.service.CategoryService;
import com.example.caree.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/secured", "/secured/posts"})
public class SecuredPostsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService postService = new PostService();
        List<Post> postList = postService.fetchAllPosts();
        req.setAttribute("posts", postList);
        req.getRequestDispatcher("/WEB-INF/secured-post-list.jsp").forward(req, resp);
    }
}
