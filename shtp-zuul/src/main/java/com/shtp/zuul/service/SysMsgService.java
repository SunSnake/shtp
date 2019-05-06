package com.shtp.zuul.service;

import com.shtp.zuul.bean.MsgContent;
import com.shtp.zuul.bean.SysMsg;
import com.shtp.zuul.bean.User;
import com.shtp.zuul.common.UserUtils;
import com.shtp.zuul.mapper.SysMsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysMsgService {
    @Autowired
    SysMsgMapper sysMsgMapper;
    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ROLE_admin')")//只有管理员可以发送系统消息
    public boolean sendMsg(MsgContent msg) {
        int result = sysMsgMapper.sendMsg(msg);
        List<User> allUser = userService.getAllUser();
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
