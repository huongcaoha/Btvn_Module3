package com.ra.model.dao.role;

import com.ra.model.entity.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getListRole();
    boolean add(Role role) ;
}
