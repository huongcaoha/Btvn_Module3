package com.ra.model.dao.user;

import com.ra.model.entity.Role;
import com.ra.model.entity.User;
import com.ra.model.entity.constant.RoleEnum;

import java.util.List;

public interface UserDAO {
    List<User> getList(int page , int itemPerPage);
    boolean add(User user);
    boolean update(User user);
    boolean delete(User user);
    User findById(int id);
    Role findRoleByName(RoleEnum roleEnum);
}
