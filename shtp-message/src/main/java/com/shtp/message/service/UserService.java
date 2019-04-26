package com.shtp.message.service;

import com.shtp.common.bean.User;
import com.shtp.common.utils.UserUtils;
import com.shtp.message.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class UserService{

    @Autowired
    UserMapper UserMapper;

    public List<User> getAllUserExceptAdmin() {
        return UserMapper.getAllUser(UserUtils.getCurrentUser().getId());
    }

    public List<User> getAllUser() {
        return UserMapper.getAllUser(null);
    }
}
