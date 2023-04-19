package com.example.caree.servlet;

import com.example.caree.DAO.CategoryDao;
import com.example.caree.model.Category;
import com.example.caree.model.Post;
import com.example.caree.service.CategoryService;
import com.example.caree.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = "/secured/create-category")
public class CreateCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/create-category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        Category newCategory = new Category(10000L,name);
        new CategoryService().createCategory(newCategory);
        resp.sendRedirect(req.getContextPath() + "/secured");
    }
}
