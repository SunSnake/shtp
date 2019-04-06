package com.shtp.member.service;

import com.shtp.member.bean.User;
import com.shtp.member.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegeditAction {

    @Autowired
    private UserMapper userMapper;

    public boolean InsertUser(User user){

        if (userMapper.query(user) == null){
            userMapper.insert(user);
            return true;
        } else {
            return false;
        }
    }
}
