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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/", "/posts"})
public class ShowPostsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService postService = new PostService();
        CategoryService categoryService = new CategoryService();
        List<Post> postList = postService.fetchAllPosts();
        List<Category> categoryNameList = new ArrayList<>();
        for (Post post : postList) {
            categoryNameList.add(categoryService.fetchOneCategory(post.getCategoryId()));
        }
        req.setAttribute("posts", postList);
        req.getRequestDispatcher("/WEB-INF/post-list.jsp").forward(req, resp);
    }
}
