package com.ra.model.service.role;

import com.ra.model.dao.role.RoleDAO;
import com.ra.model.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO ;
    @Override
    public List<Role> getListRole() {
        return roleDAO.getListRole();
    }

    @Override
    public boolean add(Role role) {
        return roleDAO.add(role);
    }
}
