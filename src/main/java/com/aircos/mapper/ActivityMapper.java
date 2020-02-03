package com.aircos.mapper;

import com.aircos.entity.dao.Activity;
import com.aircos.entity.vo.ActivityVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper of 首页轮播图
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Repository
public interface ActivityMapper extends BaseMapper<Activity> {

    /**
     * 获取首页轮播图列表
     *
     * @param page 分页信息
     * @return 首页轮播图列表
     */
    List<ActivityVo> activityList(IPage<ActivityVo> page);
}
