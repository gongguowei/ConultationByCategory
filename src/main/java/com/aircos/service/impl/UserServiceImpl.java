package com.aircos.service.impl;

import com.aircos.entity.dao.User;
import com.aircos.entity.dto.CreateUserDto;
import com.aircos.mapper.UserMapper;
import com.aircos.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
        user.setPassword(new BCryptPasswordEncoder().encode(body.getPassword()));

        return userMapper.insert(user);
    }
}
