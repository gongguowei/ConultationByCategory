package com.aircos.mapper;

import com.aircos.entity.dao.User;
import com.aircos.entity.dto.QueryUserDto;
import com.aircos.entity.vo.user.UserVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Mapper of 用户
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据条件返回指定格式的用户列表
     *
     * @param page 分页信息
     * @param searchInfo 查询条件
     * @return 用户列表
     */
    IPage<UserVo> listUsersByCondition(IPage<UserVo> page,
                                       @Param("searchInfo") QueryUserDto searchInfo);
}
