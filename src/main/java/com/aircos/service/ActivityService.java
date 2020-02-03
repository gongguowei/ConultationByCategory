package com.aircos.service;

import com.aircos.entity.dao.Activity;
import com.aircos.entity.dto.CreateActivityDto;
import com.aircos.entity.dto.PageInfoDto;
import com.aircos.entity.vo.ActivityVo;

import java.util.List;

/**
 * Interface of 首页活动轮播图
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
public interface ActivityService {

    /**
     * 获取首页轮播图
     *
     * @param pageIndex 页码
     * @param pageSize 页数
     * @return 首页轮播图
     */
    List<ActivityVo> list(Integer pageIndex, Integer pageSize);

    /**
     * Admin for 创建首页轮播图
     *
     * @param body 轮播图信息
     */
    void create(CreateActivityDto body);


    /**
     * Admin for 更新首页轮播图
     *
     * @param body 更新的轮播图信息
     */
    void update(Activity body);

    /**
     * Admin for 删除首页轮播图
     *
     * @param id 首页轮播图主键
     */
    void delete(int id);
}
