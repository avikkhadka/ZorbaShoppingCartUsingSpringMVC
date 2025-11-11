package com.shoppingcart.service;

import com.shoppingcart.dao.RoleDao;
import com.shoppingcart.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
