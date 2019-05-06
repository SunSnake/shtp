package com.shtp.zuul.controller;

import com.shtp.zuul.bean.RespBean;
import com.shtp.zuul.bean.User;
import com.shtp.zuul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/user")
public class SystemUserController {
    @Autowired
    UserService userService;

    @RequestMapping("/id/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public RespBean deleteUser(@PathVariable Long userId) {
        if (userService.deleteUser(userId) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateUser(User user) {
        if (userService.updateUser(user) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public RespBean updateUserRoles(Long userId, Long[] rids) {
        if (userService.updateUserRoles(userId, rids) == rids.length) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping("/{keywords}")
    public List<User> getUsersByKeywords(@PathVariable(required = false) String keywords) {
        List<User> users = userService.getUsersByKeywords(keywords);
        return users;
    }


    @RequestMapping(value = "/user/reg", method = RequestMethod.POST)
    public RespBean userReg(String username, String password) {
        int i = userService.UserReg(username, password);
        if (i == 1) {
            return RespBean.ok("注册成功!");
        } else if (i == -1) {
            return RespBean.error("用户名重复，注册失败!");
        }
        return RespBean.error("注册失败!");
    }

}
