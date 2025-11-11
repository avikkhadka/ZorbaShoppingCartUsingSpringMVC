package com.shoppingcart.dao;

import com.shoppingcart.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role role);
    Role getRoleById(Long id);
    List<Role> getAllRoles();

}
