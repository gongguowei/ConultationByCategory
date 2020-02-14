package com.aircos.service;

import com.aircos.entity.dao.UserMemberLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Interface of Vip充值日志
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
public interface UserMemberLogService extends IService<UserMemberLog> {

    /**
     * 添加一个VIP充值成功记录
     *
     * @param body
     * @return
     */
    boolean create(UserMemberLog body);

    /**
     * 查询当前登录用户是否为会员
     *
     * @return true:是会员，false:不是
     */
    boolean checkUserMember();
}
