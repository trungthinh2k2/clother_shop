package vn.edu.iuh.fit.shopclother.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.shopclother.entity.Product;
import vn.edu.iuh.fit.shopclother.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/index")
    public String index(Model model) {
        List<Product> male = productService.findMaleAdultProducts();
        List<Product> female = productService.findFemaleAdultProducts();
        List<Product> kids = productService.findKidsProducts();
        model.addAttribute("male", male);
        model.addAttribute("female", female);
        model.addAttribute("kids", kids);
        return "layout/index";
    }


    @RequestMapping("/admin")
    public String admin() {
        return "admin/auth/auth";
    }
}
