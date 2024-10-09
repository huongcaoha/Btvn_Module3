package com.ra.model.service.user;

import com.ra.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> getList();
    boolean add(User user);
    boolean update(User user);
    boolean delete(User user);
    User findById(int id);
    User checkUserExist(String phone , String password);
    boolean checkPhoneExist(String phone);
}
