package com.aircos.service.impl;

import cn.hutool.core.date.DateUtil;
import com.aircos.entity.dao.User;
import com.aircos.entity.dao.UserMemberLog;
import com.aircos.entity.dao.UserMemberMoney;
import com.aircos.mapper.UserMemberLogMapper;
import com.aircos.service.UserMemberLogService;
import com.aircos.service.UserMemberMoneyService;
import com.aircos.service.UserService;
import com.aircos.util.SecurityUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Service of 用户会员充值日志
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
@Service
public class UserMemberLogServiceImpl extends ServiceImpl<UserMemberLogMapper, UserMemberLog> implements UserMemberLogService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMemberMoneyService userMemberMoneyService;

    @Override
    public boolean create(UserMemberLog body) {
        UserMemberMoney.UserMemberMoneyBuilder builder = UserMemberMoney.builder();
        if(null == body.getUserId()){
            User loginUser = userService.findByPhone(SecurityUtils.getPhone());
            body.setUserId(loginUser.getId());
        }

        UserMemberMoney userMemberMoney = userMemberMoneyService.getById(body.getUserId());
        UserMemberLog oldLog = this.getOne(new QueryWrapper<UserMemberLog>()
                .eq(UserMemberLog.USER_ID, body.getUserId())
                .eq(UserMemberLog.DEL_FLAG, 0));

        //判断是不是会员续费
        if (null == oldLog) {
            Date startTime = new Date();
            body.setStartTime(startTime);
            body.setEndTime(DateUtil.offsetMonth(startTime, body.getType()));
        } else {
            oldLog.setDelFlag(1);
            this.update(oldLog, new UpdateWrapper<UserMemberLog>()
                    .eq(UserMemberLog.ID, oldLog.getId()));
            body.setStartTime(oldLog.getStartTime());
            body.setEndTime(DateUtil.offsetMonth(oldLog.getEndTime(), body.getType()));
        }

        //设置总额
        if (null == userMemberMoney) {
            builder.id(body.getUserId())
                    .money(body.getMoney())
                    .lastTime(new Date())
                    .isMember(true);
        } else {
            builder.id(body.getUserId()).money(body.getMoney() + userMemberMoney.getMoney())
                    .lastTime(new Date())
                    .isMember(true);
        }

        this.save(body);
        return userMemberMoneyService.saveOrUpdate(builder.build());
    }

    @Override
    public boolean checkUserMember() {
        User loginUser = userService.findByPhone(SecurityUtils.getPhone());
        UserMemberMoney userMember = userMemberMoneyService.getOne(new QueryWrapper<UserMemberMoney>()
                .eq("id", loginUser.getId()));
        if (null == userMember) {
            return false;
        }
        return userMember.getIsMember();
    }
}
