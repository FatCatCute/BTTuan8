package com.example.BTTuan8.controller;

import com.example.BTTuan8.entity.Product;
import com.example.BTTuan8.service.CategoryService;
import com.example.BTTuan8.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RequestMapping("admin.products")
@Controller
public class AdminProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("listproduct", productService.getAll());
        return "admin/products/index.html";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listCategory", categoryService.getAllCategories());
        return "admin/products/create";
    }

    @PostMapping("/create")
    public String create(@Valid Product newProduct,
                         @RequestParam MultipartFile imageProduct,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", newProduct);
            model.addAttribute("listCategory", categoryService.getAllCategories());
            return "admin/products/create";
        }
        if (imageProduct != null && imageProduct.getSize() > 0) {
            try {
                File saveFile = new ClassPathResource("static/images").getFile();
                String newImageFile = UUID.randomUUID() + ".png";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/products";
    }
}

