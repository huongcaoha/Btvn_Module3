package com.ra.dao;

import com.ra.model.entity.User;

import java.util.List;

public interface UserDAO {
    public void insertUser(User user) ;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) ;

    public boolean updateUser(User user) ;
}
