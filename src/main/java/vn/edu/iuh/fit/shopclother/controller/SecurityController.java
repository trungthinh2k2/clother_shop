package vn.edu.iuh.fit.shopclother.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.shopclother.entity.Account;
import vn.edu.iuh.fit.shopclother.services.AccountService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/signup")
    public String signup() {
        return "security/signup";
    }

//    @PostMapping("/signup/save")
//    public String signupSave(@ModelAttribute("account") Account account, Model model) {
//        accountService.create(account);
//        return "redirect:/security/login";
//    }

    @PostMapping("/signup/save")
    public String signupSave(@ModelAttribute("account") Account account, Model model) {
        accountService.create(account);
        return "redirect:/security/login";
    }

    @GetMapping("/login")
    public String login() {
        return "security/login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("account") Account account) {
        Account account1 = accountService.findAccountById(account.getUserName());
        if (account1 != null && account1.getPassword().equals(account.getPassword())) {
            return "redirect:/home/index";
        }
        return "security/login";
    }

//    @RequestMapping("/login/form")
//    public String loginForm(Model model) {
//        model.addAttribute("message", "Vui lòng đăng nhập!");
//        return "security/login";
//    }
//
//    @RequestMapping("/login/success")
//    public String loginSuccess(Model model) {
//        model.addAttribute("message", "Đăng nhập thành công!");
//        return "redirect:home/index";
//    }
//
//    @RequestMapping("/login/error")
//    public String loginError(Model model) {
//        model.addAttribute("message", "Sai thông tin đăng nhập!");
//        return "security/login";
//    }

    @CrossOrigin("*")
    @ResponseBody
    @RequestMapping("/rest/security/authentication")
    public Object getAuthentication(HttpSession session) {
        return session.getAttribute("authentication");
    }
}
