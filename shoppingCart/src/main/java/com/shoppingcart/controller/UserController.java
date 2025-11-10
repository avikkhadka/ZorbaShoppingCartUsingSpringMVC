package com.shoppingcart.controller;

import com.shoppingcart.model.User;
import com.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")

    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "user_register";

    }

    //saving the user registration details in the database
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user, Model model) {
        userService.registerUser(user);
        model.addAttribute("message", "User registered Successfully");
        return "user_register";


    }

    //login functionality
    @GetMapping("/login")
    public String showLoginForm(Model model)
    {
        model.addAttribute("user",new User());
        return "user_login";
    }
    @PostMapping("/login")

    public String loginCheck(@ModelAttribute User user, Model model)
    {
        User existingUser=userService.checkLoginCredentials(user.getEmail(),user.getPassword());

        if(existingUser!=null)
        {
            model.addAttribute("message","Login successfull");
            return "user_dashbord";
        }
        else
        {
            model.addAttribute("message","Invalid email or password");
            return "user_login";
        }

    }
}
