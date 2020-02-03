package com.aircos.mapper;

import com.aircos.entity.dao.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Mapper of 用户
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
