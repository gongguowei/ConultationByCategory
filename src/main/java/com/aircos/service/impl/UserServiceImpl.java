package com.aircos.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.aircos.entity.dao.User;
import com.aircos.entity.dao.UserMemberMoney;
import com.aircos.entity.dto.CreateUserDto;
import com.aircos.entity.dto.QueryUserDto;
import com.aircos.entity.dto.UpdateUserDto;
import com.aircos.entity.vo.user.UserVo;
import com.aircos.manager.SmsManager;
import com.aircos.mapper.UserMapper;
import com.aircos.mapper.UserMemberMoneyMapper;
import com.aircos.service.UserService;
import com.aircos.util.SecurityUtils;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Service of 用户业务层
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SmsManager smsManager;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMemberMoneyMapper userMemberMoneyMapper;

    @Override
    public User findByPhone(String phone) {
        return userMapper.selectOne(new QueryWrapper<User>()
                .lambda()
                .eq(User::getPhoneNumber, phone));
    }

    @Override
    public int createUser(CreateUserDto body) {
        if (!body.getPassword().equals(body.getConfirmPassword())) {
            throw new ServiceException("两次密码输入不一致");
        }
        User checkOnlyOne = userMapper.selectOne(new QueryWrapper<User>()
                .lambda()
                .eq(User::getPhoneNumber, body.getPhone()));
        if (null != checkOnlyOne) {
            throw new ServiceException("手机号已被注册");
        }
        //TODO 使用builder模式, 防止后期类的参数演化到失控
        User user = new User();
        user.setPhoneNumber(body.getPhone());
        user.setNickName(body.getNickName());
        user.setSchoolName(body.getSchoolName());
        user.setStudySubject(body.getStudySubject());
        user.setSchoolAddress(body.getSchoolAddress());
        user.setPassword(new BCryptPasswordEncoder().encode(body.getPassword()));

        return userMapper.insert(user);
    }

    @Override
    public void update(UpdateUserDto body) {
        User loginUser = findByPhone(SecurityUtils.getPhone());

        if (null == loginUser) {
            throw new ServiceException("用户不存在");
        }

        CopyOptions copyOptions = CopyOptions.create().ignoreNullValue();
        BeanUtil.copyProperties(body, loginUser, copyOptions);

        userMapper.updateById(loginUser);
    }

    @Override
    public User getUser() {
        User loginUser = findByPhone(SecurityUtils.getPhone());
        return userMapper.selectById(loginUser.getId());
    }

    @Override
    public IPage<UserVo> listUsers(Integer pageIndex, Integer pageSize, QueryUserDto query) {
        IPage<UserVo> page = new Page(pageIndex, pageSize);
        IPage<UserVo> result = userMapper.listUsersByCondition(page, query);

        //动态计算用户是否是会员
        List<UserVo> records = result.getRecords();
        records.forEach(userVo -> {
            UserMemberMoney checkMember = userMemberMoneyMapper.selectById(userVo.getId());
            userVo.setUserType(checkMember.getIsMember());
        });
        return result;
    }

    @Override
    public void sendRegisterCode(String mobile) throws ClientException {
        Integer code = (int)((Math.random()*9+1)*100000);

        redisTemplate.opsForValue().set(mobile, code, 10*60, TimeUnit.SECONDS);
        smsManager.sendMessage(mobile, code);
    }
}
