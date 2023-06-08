package com.example.BTTuan8.controller;

import com.example.BTTuan8.entity.Product;
import com.example.BTTuan8.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "products/create";
    }

    @PostMapping("/create")
    public String create(@Valid Product newProduct, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", newProduct);
            return "products/create";
        }

        productService.add(newProduct);
        return "redirect:/products";
    }

    @GetMapping("")
    public String index(@RequestParam(required = false) String name, @RequestParam(required = false) Long price, Model model) {
        List<Product> products = productService.getAll();

        model.addAttribute("listproduct", products);
        model.addAttribute("name", name);
        model.addAttribute("price", price);

        return "products/index";
    }

        @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "redirect:/products";

    }



    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        Product product = productService.get(id);
        model.addAttribute("product", product);

        return "products/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid Product updatedProduct,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors())
        {
            model.addAttribute("product", updatedProduct);
            return "products/edit";
        }
        productService.update(updatedProduct);
        return "redirect:/products/" + updatedProduct.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}

//@Controller
//@RequestMapping("/products")
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("product", new Product());
//        return "products/create";
//    }
//
//    @PostMapping("/create")
//    public String create(@Valid Product newProduct,
//                         BindingResult result,
//                         Model model) {
//        if (result.hasErrors())
//        {
//            model.addAttribute("product", newProduct);
//            return "products/create";
//        }
//        productService.add(newProduct);
//        return "redirect:/products";
//    }
//
////    @GetMapping("")
////    public  String index(Model model)
////    {
////        model.addAttribute("listproduct", productService.GetAll());
////        return  "products/index";
////    }
//
//    @GetMapping("")
//    public String index(@RequestParam(required = false) String name,
//                        @RequestParam(required = false) Long price,
//                        Model model)
//    {
//        List<Product> products = productService.getAll(name, price);
//
//        model.addAttribute("listproduct", products);
//        model.addAttribute("name", name);
//        model.addAttribute("price", price);
//
//        return "products/index";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable int id, Model model) {
//        Product product = productService.get(id);
//        model.addAttribute("product", product);
//        return "redirect:/products";
//
//    }
//
//
//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable int id, Model model) {
//        Product product = productService.get(id);
//        model.addAttribute("product", product);
//
//        return "products/edit";
//    }
//
//    @PostMapping("/edit")
//    public String update(@Valid Product updatedProduct,
//                         BindingResult result,
//                         Model model) {
//        if (result.hasErrors())
//        {
//            model.addAttribute("product", updatedProduct);
//            return "products/edit";
//        }
//        productService.update(updatedProduct);
//        return "redirect:/products/" + updatedProduct.getId();
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable int id) {
//        productService.delete(id);
//        return "redirect:/products";
//    }
//
//
//
//}