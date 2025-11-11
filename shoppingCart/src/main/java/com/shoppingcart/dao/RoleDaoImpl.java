package com.shoppingcart.dao;

import com.shoppingcart.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
@Autowired
private SessionFactory sessionFactory;
    @Override
    public void addRole(Role role) {
        Session session=sessionFactory.getCurrentSession();
        session.save(role);

    }

    @Override
    public Role getRoleById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class, id);
    }

    @Override
    public List<Role> getAllRoles() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Role", Role.class).getResultList();

    }
}
