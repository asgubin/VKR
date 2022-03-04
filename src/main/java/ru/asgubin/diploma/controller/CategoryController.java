package ru.asgubin.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.asgubin.diploma.entity.Category;
import ru.asgubin.diploma.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public void categoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String getCategory(Model model) {

        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        return "categories";
    }
}
