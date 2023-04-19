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

@WebServlet(urlPatterns = {"/secured/categories"})
public class SecuredCategoriesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.fetchAllCategories();
        req.setAttribute("categories", categoryList);
        req.getRequestDispatcher("/WEB-INF/secured-category-list.jsp").forward(req, resp);
    }
}
