package ru.pigarev.springbootproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pigarev.springbootproj.model.Product;
import ru.pigarev.springbootproj.services.ProductService;

@Controller
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    //GET http://localhost:8189/app/start
    @GetMapping("/start")
    @ResponseBody
    public String greettings() {

        return "Hello!";
    }

    //GET http://localhost:8189/app/show_all
    @GetMapping("/show_all")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    //GET http://localhost:8189/app/show/{id}
    @GetMapping("/show/{id}")
    public String showProductPageById(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProduct(id));
        return "product_info";
    }

    //GET http://localhost:8189/app/create
    @GetMapping("/create")
    public String createProduct() {

        return "create_product";
    }

    //POST http://localhost:8189/app/create
    @PostMapping("/create")
    public String saveProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Double cost) {
        productService.saveProduct(new Product(id, title, cost));
        return "redirect:/show_all";
    }
}
