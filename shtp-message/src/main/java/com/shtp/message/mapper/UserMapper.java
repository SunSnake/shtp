package com.shtp.message.mapper;

import com.shtp.common.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
public interface UserMapper {

    List<User> getAllUser(@Param("currentId") Long currentId);
}
