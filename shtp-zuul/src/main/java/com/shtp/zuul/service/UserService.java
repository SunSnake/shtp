package com.shtp.zuul.service;

import com.shtp.zuul.bean.User;
import com.shtp.zuul.common.UserUtils;
import com.shtp.zuul.mapper.UserMapper;
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
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User User = userMapper.loadUserByUsername(s);
        if (User == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return User;
    }

    public int UserReg(String username, String password) {
        //如果用户名存在，返回错误
        if (userMapper.loadUserByUsername(username) != null) {
            return -1;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        return userMapper.userReg(username, encode);
    }

    public List<User> getUsersByKeywords(String keywords) {
        return userMapper.getUsersByKeywords(keywords);
    }

    public int updateUser(User User) {
        return userMapper.updateUser(User);
    }

    public int updateUserRoles(Long UserId, Long[] rids) {
        int i = userMapper.deleteRoleByUserId(UserId);
        return userMapper.addRolesForUser(UserId, rids);
    }

    public User getUserById(Long UserId) {
        return userMapper.getUserById(UserId);
    }

    public int deleteUser(Long UserId) {
        return userMapper.deleteUser(UserId);
    }

    public List<User> getAllUserExceptAdmin() {
        return userMapper.getAllUser(UserUtils.getCurrentUser().getId());
    }
    public List<User> getAllUser() {
        return userMapper.getAllUser(null);
    }
}
