package com.shtp.zuul.mapper;

import com.shtp.zuul.bean.MsgContent;
import com.shtp.zuul.bean.SysMsg;
import com.shtp.zuul.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMsgMapper {

    int sendMsg(MsgContent msg);

    int addMsg2AllUser(@Param("users") List<User> users, @Param("mid") Long mid);

    List<SysMsg> getSysMsg(@Param("start") int start, @Param("size") Integer size, @Param("userid") Long userid);

    int markRead(@Param("flag") Long flag, @Param("userid") Long userid);
}
