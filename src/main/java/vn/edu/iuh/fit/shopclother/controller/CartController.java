package vn.edu.iuh.fit.shopclother.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    @RequestMapping("/view")
    public String cartView() {
        return "cart/cart-view";
    }
}
