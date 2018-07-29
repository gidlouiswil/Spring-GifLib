package com.gidlouiswil.giflib.controller;

import com.gidlouiswil.giflib.data.CategoryRepository;
import com.gidlouiswil.giflib.data.GifRepository;
import com.gidlouiswil.giflib.model.Category;
import com.gidlouiswil.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController
{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap)
    {
        List<Category> allCategories = categoryRepository.getAllCategories();
        modelMap.put("categories", allCategories);
        return "categories";
    }

    // http://localhost:8080/gif/android-explosion
    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap)
    {
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);
        return "category";
    }
}
