package com.shtp.member.dao;

import com.shtp.member.bean.User;

public interface UserMapper {
    User query(User user);
    void insert(User user);
    void delete(User user);
    void update(User user);
}
