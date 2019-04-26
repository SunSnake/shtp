package com.shtp.security.controller;

import com.shtp.common.bean.User;
import com.shtp.common.bean.RespBean;
import com.shtp.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sang on 2018/1/2.
 */
@RestController
@RequestMapping("/system/User")
public class SystemUserController {
    @Autowired
    UserService UserService;

    @RequestMapping("/id/{UserId}")
    public User getUserById(@PathVariable Long UserId) {
        return UserService.getUserById(UserId);
    }

    @RequestMapping(value = "/{UserId}", method = RequestMethod.DELETE)
    public RespBean deleteUser(@PathVariable Long UserId) {
        if (UserService.deleteUser(UserId) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateUser(User User) {
        if (UserService.updateUser(User) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public RespBean updateUserRoles(Long UserId, Long[] rids) {
        if (UserService.updateUserRoles(UserId, rids) == rids.length) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping("/{keywords}")
    public List<User> getUsersByKeywords(@PathVariable(required = false) String keywords) {
        List<User> Users = UserService.getUsersByKeywords(keywords);
        return Users;
    }


    @RequestMapping(value = "/User/reg", method = RequestMethod.POST)
    public RespBean UserReg(String username, String password) {
        int i = UserService.UserReg(username, password);
        if (i == 1) {
            return RespBean.ok("注册成功!");
        } else if (i == -1) {
            return RespBean.error("用户名重复，注册失败!");
        }
        return RespBean.error("注册失败!");
    }

}
