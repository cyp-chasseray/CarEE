package com.example.caree.service;
import com.example.caree.DAO.CategoryDao;
import com.example.caree.model.Category;
import java.util.List;

public class CategoryService {

    public List<Category> fetchAllCategories() {
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.fetchAll();
    }

    public Category fetchOneCategory(int id) {
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.fetchOne(id);
    }

    public void createCategory(Category category) {
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.create(category);
    }

    public void deleteCategory(int id) {
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.delete(id);
    }

    public void updateCategory(int id) {
//        CategoryDao categoryDao = new CategoryDao();
//        categoryDao.update(id);
    }


}
