package com.shtp.security.service;

import com.shtp.common.bean.User;
import com.shtp.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper UserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User User = UserMapper.loadUserByUsername(s);
        if (User == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return User;
    }

    public int UserReg(String username, String password) {
        //如果用户名存在，返回错误
        if (UserMapper.loadUserByUsername(username) != null) {
            return -1;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        return UserMapper.UserReg(username, encode);
    }

    public List<User> getUsersByKeywords(String keywords) {
        return UserMapper.getUsersByKeywords(keywords);
    }

    public int updateUser(User User) {
        return UserMapper.updateUser(User);
    }

    public int updateUserRoles(Long UserId, Long[] rids) {
        int i = UserMapper.deleteRoleByUserId(UserId);
        return UserMapper.addRolesForUser(UserId, rids);
    }

    public User getUserById(Long UserId) {
        return UserMapper.getUserById(UserId);
    }

    public int deleteUser(Long UserId) {
        return UserMapper.deleteUser(UserId);
    }
}
