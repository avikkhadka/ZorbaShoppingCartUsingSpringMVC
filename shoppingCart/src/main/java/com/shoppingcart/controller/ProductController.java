package com.shoppingcart.controller;

import com.shoppingcart.model.Product;
import com.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/add")
    public String showAddProductForm(Model model)
    {
        model.addAttribute("product",new Product());
        return "product_add";
    }

    @PostMapping("/add")

    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes)
    {
        productService.addProduct(product);

        redirectAttributes.addFlashAttribute("message", "Product has been added successfully!");
        return "redirect:/product/list";
    }

    //getting all the products
    @GetMapping("/list")
    public String listProducts(@RequestParam(value = "type",required = false) String type, Model model)
    {
        if (type != null && !type.isEmpty()) {
            model.addAttribute("products", productService.getProductsByType(type));
        } else {
            model.addAttribute("products", productService.getAllProducts());
        }
        return "product_list";
    }
    //product single view
    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable("id") Long id, Model model)
    {
        Product product=productService.getProductById(id);
        if(product==null)
        {
            model.addAttribute("message","Product not found");
            return "redirect:/product/list";
        }
        model.addAttribute("product", product);
        return "product_view";
    }
}
