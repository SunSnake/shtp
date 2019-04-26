package com.shtp.security.mapper;

import com.shtp.common.bean.User;
import com.shtp.common.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
public interface UserMapper {
    User loadUserByUsername(String username);

    List<Role> getRolesByUserId(Long id);

    int UserReg(@Param("username") String username, @Param("password") String password);

    List<User> getUsersByKeywords(@Param("keywords") String keywords);

    int updateUser(User User);

    int deleteRoleByUserId(Long UserId);

    int addRolesForUser(@Param("UserId") Long UserId, @Param("rids") Long[] rids);

    User getUserById(Long UserId);

    int deleteUser(Long UserId);

}
