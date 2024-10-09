package com.ra.model.dao.user;

import com.ra.model.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getList();
    boolean add(User user);
    boolean update(User user);
    boolean delete(User user);
    User findById(int id);
}
