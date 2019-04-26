package com.shtp.message.mapper;

import com.shtp.common.bean.User;
import com.shtp.message.bean.MsgContent;
import com.shtp.message.bean.SysMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sang on 2018/2/2.
 */
public interface SysMsgMapper {

    int sendMsg(MsgContent msg);

    int addMsg2AllUser(@Param("Users") List<User> Users, @Param("mid") Long mid);

    List<SysMsg> getSysMsg(@Param("start") int start, @Param("size") Integer size, @Param("Userid") Long Userid);

    int markRead(@Param("flag") Long flag, @Param("Userid") Long Userid);
}
