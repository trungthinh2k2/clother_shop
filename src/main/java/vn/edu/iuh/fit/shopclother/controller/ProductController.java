package vn.edu.iuh.fit.shopclother.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.shopclother.entity.Product;
import vn.edu.iuh.fit.shopclother.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String getAll(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "product/products";
    }

    @RequestMapping("/men")
    public String men(Model model) {
        List<Product> male = productService.findMaleAdultProducts();
        model.addAttribute("male", male);
        return "product/men-product";
    }

    @RequestMapping("/woman")
    public String woman(Model model) {
        List<Product> female = productService.findFemaleAdultProducts();
        model.addAttribute("female", female);
        return "product/woman-product";
    }

    @RequestMapping("/kids")
    public String kids(Model model) {
        List<Product> kids = productService.findKidsProducts();
        model.addAttribute("kids", kids);
        return "product/kids-product";
    }

    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/product-detail";
    }
}
