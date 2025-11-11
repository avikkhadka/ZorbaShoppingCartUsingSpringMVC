package com.shoppingcart.controller;

import com.shoppingcart.model.Role;
import com.shoppingcart.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    public String showAddRoleForm(Model model) {
        model.addAttribute("role", new Role());
        return "role_add";
    }

    @PostMapping("/add")
    public String saveRole(@ModelAttribute Role role, Model model) {
        roleService.addRole(role);
        model.addAttribute("message", "Role added successfully!");
        return "role_add";
    }

    @GetMapping("/list")
    public String listRoles(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "role_list";
    }
}
