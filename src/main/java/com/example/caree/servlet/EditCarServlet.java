package com.example.caree.servlet;

import com.example.caree.DAO.CategoryDao;
import com.example.caree.DAO.PostDao;
import com.example.caree.model.Category;
import com.example.caree.model.Post;
import com.example.caree.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = "/secured/edit-car")
public class EditCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("id"));
        Post post = new PostDao().fetchOne(postId);
        Category category = new CategoryDao().fetchOne(post.getCategoryId());
        req.setAttribute("post", post);
        req.setAttribute("category", category);
        req.getRequestDispatcher("/WEB-INF/edit-car.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choice = req.getParameter("choice");
        int id = Integer.parseInt(req.getParameter("id"));
        if (choice.equals("delete")) {
            new PostService().deletePost(id);
            resp.sendRedirect(req.getContextPath() + "/secured");
        } else {
            String name = req.getParameter("title");
            String content = req.getParameter("content");
            double price = Double.parseDouble(req.getParameter("price"));
            String categoryName = req.getParameter("category");
            Category category = new CategoryDao().fetchOneByName(categoryName);
            int categoryId = (int) category.getId();
            Post postToUpdate = new Post((long) id, name, content, price, categoryId);
            new PostService().updatePost(id, postToUpdate);
            resp.sendRedirect(req.getContextPath() + "/secured");
        }
    }
}

