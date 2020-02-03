package com.aircos.task;

import com.aircos.entity.dao.UserMemberLog;
import com.aircos.entity.dao.UserMemberMoney;
import com.aircos.service.UserMemberLogService;
import com.aircos.service.UserMemberMoneyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 会员清理定时器
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@Slf4j
@Component
public class MemberClearTask {
    @Autowired
    private UserMemberLogService userMemberLogService;

    @Autowired
    private UserMemberMoneyService userMemberMoneyService;

    @Scheduled(cron = "0 0 1 * * ?")
    @Async
    public void clearMember(){
        QueryWrapper<UserMemberLog> eq = new QueryWrapper<UserMemberLog>()
                .le(UserMemberLog.END_TIME, new Date())
                .eq(UserMemberLog.DEL_FLAG, 0);

        List<UserMemberLog> userMemberLogs = userMemberLogService.list(eq);
        if (!userMemberLogs.isEmpty()) {
            List<Integer> userIds = new ArrayList<>();
            userMemberLogs.forEach(item -> {
                userIds.add(item.getUserId());
            });
            userMemberMoneyService.update(UserMemberMoney.builder().isMember(false).build(),
                    new QueryWrapper<UserMemberMoney>().in(UserMemberMoney.ID, userIds));
        }
        userMemberLogService.update( UserMemberLog.builder().delFlag(1).build(), eq);
    }
}