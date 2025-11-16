package com.shoppingcart.controller;

import com.shoppingcart.model.Role;
import com.shoppingcart.model.User;
import com.shoppingcart.service.RoleService;
import com.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    // 🧩 Prevent Spring from auto-binding roles field
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("roles");
    }

    // ---------------- REGISTER PAGE ----------------
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "user_register";
    }

    // ---------------- SAVE USER ----------------
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user,
                           @RequestParam(value = "roles", required = false) List<Long> roleIds,
                           Model model) {

        if (roleIds != null && !roleIds.isEmpty()) {
            Set<Role> selectedRoles = new HashSet<>();
            for (Long roleId : roleIds) {
                Role role = roleService.getRoleById(roleId);
                selectedRoles.add(role);
            }
            user.setRoles(selectedRoles);
        }

        userService.registerUser(user);

        model.addAttribute("message", "User registered successfully!");
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "user_login";
    }

    // ---------------- LOGIN PAGE ----------------
    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "error", required = false) String error,
                                Model model) {
        if (error != null) {
            model.addAttribute("errorMsg", "Invalid username or password");
        }

        return "redirect:/user/login";
    }




    // ---------------- LOGOUT ----------------
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }
}
