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
@WebServlet(urlPatterns = "/secured/create-car")
public class CreateCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/create-car.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String name = req.getParameter("title");
            String content = req.getParameter("content");
            double price = Double.parseDouble(req.getParameter("price"));
            String categoryName = req.getParameter("category");
            String pictureUrl = req.getParameter("pictureUrl");
            Category category = new CategoryDao().fetchOneByName(categoryName);
            int categoryId = (int) category.getId();
            Post newPost = new Post(10000L,name, content, price, categoryId, pictureUrl);
            new PostService().createPost(newPost);
            resp.sendRedirect(req.getContextPath() + "/secured");
        }
    }

