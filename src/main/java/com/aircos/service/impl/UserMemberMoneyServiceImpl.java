package com.aircos.service.impl;

import com.aircos.entity.dao.UserMemberMoney;
import com.aircos.mapper.UserMemberMoneyMapper;
import com.aircos.service.UserMemberMoneyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service of 用户会员充值
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
@Slf4j
@Service
public class UserMemberMoneyServiceImpl extends ServiceImpl<UserMemberMoneyMapper, UserMemberMoney> implements UserMemberMoneyService {
}
