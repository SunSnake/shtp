package com.shtp.zuul.controller;

import com.shtp.zuul.bean.User;
import com.shtp.zuul.common.UserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这是一个只要登录就能访问的Controller
 * 主要用来获取一些配置信息
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @RequestMapping("/user")
    public User currentUser() {
        return UserUtils.getCurrentUser();
    }
}
