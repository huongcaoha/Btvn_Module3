package com.ra.model.service;

import com.ra.model.dao.UserInterface;
import com.ra.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserInterfaceiplm implements UserInterface {
    @Override
    public List<User> getListUser() {
        List<User> users = new ArrayList<>();
        users.add(new User(1,"Nguyễn Công Hưởng","123456789","0367508795","huongcaoha@gmail.com"));
        users.add(new User(2,"Nguyễn Công Hưởng123","123456789","0367508796","huongcaoha123@gmail.com"));
        users.add(new User(3,"Nguyễn Công Hưởng456","123456789","0367508797","huongcaoha456@gmail.com"));
        users.add(new User(4,"Nguyễn Công Hưởng789","123456789","0367508798","huongcaoha789@gmail.com"));
        users.add(new User(5,"Nguyễn Công Hưởng147","123456789","0367508799","huongcaoha147@gmail.com"));
        users.add(new User(6,"Nguyễn Công Hưởng258","123456789","0367508710","huongcaoha258@gmail.com"));
        users.add(new User(7,"Nguyễn Công Hưởng369","123456789","0367508711","huongcaoha369@gmail.com"));
        return users ;

    }
}
