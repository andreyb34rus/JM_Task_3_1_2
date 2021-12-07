package com.andreyb34rus.JM_Task_3_1_2.controller;

import com.andreyb34rus.JM_Task_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {("/login"), ("/index"), ("/")})
    public String login(Model model) {
        return "/login";
    }

    @GetMapping(value = "/user")
    public String getUserPage(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByEmail(principal.getName()));
        return "/user";
    }

    @GetMapping(value = "111")
    public String get111(){
        return "/111";
    }
}
