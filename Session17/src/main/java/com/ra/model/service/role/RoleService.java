package com.ra.model.service.role;

import com.ra.model.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getListRole();
    boolean add(Role role) ;
}
