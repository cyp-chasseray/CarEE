package com.example.caree.servlet;

import com.example.caree.DAO.CategoryDao;
import com.example.caree.DAO.PostDao;
import com.example.caree.model.Category;
import com.example.caree.model.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(urlPatterns = {"/details-car"})
public class DetailsCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("id"));
        Post post = new PostDao().fetchOne(postId);
        Category category = new CategoryDao().fetchOne(post.getCategoryId());
        req.setAttribute("post", post);
        req.setAttribute("category", category);
        req.getRequestDispatcher("/WEB-INF/details-car.jsp").forward(req, resp);
    }
}

