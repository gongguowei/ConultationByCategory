package com.aircos.service;

import com.aircos.entity.dao.User;
import com.aircos.entity.dto.CreateUserDto;
import com.aircos.entity.dto.QueryUserDto;
import com.aircos.entity.dto.UpdateUserDto;
import com.aircos.entity.vo.user.UserVo;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.core.metadata.IPage;

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

    /**
     * 修改用户个人信息
     *
     * @param body 用户信息
     */
    void update(UpdateUserDto body);

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    User getUser();

    /**
     * 批量获取用户信息
     *
     * @param pageIndex 页码
     * @param pageSize 页数
     * @param query 查询条件
     * @return 用户信息列表
     */
    IPage<UserVo> listUsers(Integer pageIndex, Integer pageSize, QueryUserDto query);

    /**
     * 发送用户注册短信验证码
     *
     * @param phone 手机号
     * @throws ClientException
     */
    void sendRegisterCode(String phone) throws ClientException;

    /**
     * 管理员登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    User login(String userName, String password);
}
