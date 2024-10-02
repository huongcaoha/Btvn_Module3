package com.ra.dao.impl;

import com.ra.dao.UserDAO;
import com.ra.model.entity.User;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public void insertUser(User user) {

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
