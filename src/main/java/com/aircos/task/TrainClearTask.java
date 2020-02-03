package com.aircos.task;

import com.aircos.entity.dao.Train;
import com.aircos.entity.dao.UserMemberLog;
import com.aircos.entity.dao.UserMemberMoney;
import com.aircos.mapper.TrainMapper;
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
 * 培训信息清楚定时器
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-03
 */
@Slf4j
@Component
public class TrainClearTask {
    @Autowired
    private TrainMapper trainMapper;


    @Scheduled(cron = "0 0 1 * * ?")
    @Async
    public void clearTrain(){
        //val 报名状态 0-未开始 1-进行中 2-已结束
        List<Train> trains = trainMapper.selectList(new QueryWrapper<Train>()
                .lambda()
                .le(Train::getEndTime, new Date())
                .eq(Train::getApplyStatus, 1));
        if (!trains.isEmpty()) {
            List<Integer> userIds = new ArrayList<>();
            trains.forEach(item -> {
                userIds.add(item.getId());
            });
            trainMapper.update(Train.builder().applyStatus(2).build(),
                    new QueryWrapper<Train>().in(Train.ID, userIds));
        }
    }
}
