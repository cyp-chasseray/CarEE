package com.example.caree.servlet;
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
import java.util.List;

@WebServlet(urlPatterns = {"/categories"})
public class ShowCategoriesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.fetchAllCategories();
        req.setAttribute("categories", categoryList);
        req.getRequestDispatcher("/WEB-INF/category-list.jsp").forward(req, resp);
    }
}
