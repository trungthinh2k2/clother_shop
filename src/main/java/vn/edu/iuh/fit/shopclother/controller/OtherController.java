package vn.edu.iuh.fit.shopclother.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/other")
public class OtherController {

    @GetMapping("/about")
    public String aboutView() {
        return "other/about";
    }

    @GetMapping("/contact")
    public String contactView() {
        return "other/contact";
    }
}
