package com.shtp.member.service;

import com.shtp.member.bean.User;
import com.shtp.member.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAction {

    @Autowired
    private UserMapper userMapper;

    public boolean varifyUser(User user){
        User u = userMapper.query(user);

        if (u != null && u.getPassword().equals(user.getPassword())){
            return true;
        } else {
            return false;
        }
    }
}
