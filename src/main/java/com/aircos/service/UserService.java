package com.aircos.service;

import com.aircos.entity.dao.User;
import com.aircos.entity.dto.CreateUserDto;

/**
 * Interface of 用户
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
public interface UserService {

    /**
     * 通过手机号查询对应的用户
     *
     * @param phone 手机号
     * @return 用户
     */
    User findByPhone(String phone);

    /**
     * 创建用户
     *
     * @param body 用户信息
     * @return 1:成功
     */
    int createUser(CreateUserDto body);
}
