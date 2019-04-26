package com.shtp.message.service;

import com.shtp.common.bean.User;
import com.shtp.message.bean.MsgContent;
import com.shtp.message.bean.SysMsg;
import com.shtp.common.utils.UserUtils;
import com.shtp.message.mapper.SysMsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2018/2/2.
 */
@Service
@Transactional
public class SysMsgService {
    @Autowired
    SysMsgMapper sysMsgMapper;
    @Autowired
    UserService UserService;

    @PreAuthorize("hasRole('ROLE_admin')")//只有管理员可以发送系统消息
    public boolean sendMsg(MsgContent msg) {
        int result = sysMsgMapper.sendMsg(msg);
        List<User> allUser = UserService.getAllUser();
        int result2 = sysMsgMapper.addMsg2AllUser(allUser, msg.getId());
        return result2==allUser.size();
    }

    public List<SysMsg> getSysMsgByPage(Integer page, Integer size) {
        int start = (page - 1) * size;
        return sysMsgMapper.getSysMsg(start,size, UserUtils.getCurrentUser().getId());
    }

    public boolean markRead(Long flag) {
        if (flag != -1) {
            return sysMsgMapper.markRead(flag,UserUtils.getCurrentUser().getId())==1;
        }
        sysMsgMapper.markRead(flag,UserUtils.getCurrentUser().getId());
        return true;
    }
}
