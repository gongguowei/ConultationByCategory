package com.aircos.service;

import com.aircos.entity.dao.Headline;
import com.aircos.entity.dto.QueryHeadlineDto;
import com.aircos.entity.vo.HeadlineVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * Interface of 首页招生头条
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
public interface HeadlineService {

    /**
     * 用户端：获取首页招生头条列表
     *
     * @param pageIndex 页码
     * @param pageSize 页数
     * @return
     */
    IPage<HeadlineVo> list(Integer pageIndex, Integer pageSize);

    /**
     * 用户端：获取首页招生头条详情
     *
     * @param query 查询参数
     * @return 招生头条详情
     */
    Headline detail(QueryHeadlineDto query);

    /**
     * 管理员端：创建首页招生头条列表
     *
     * @param body 招生头条信息
     */
    void create(Headline body);

    /**
     * 管理员端：更新首页招生头条列表
     *
     * @param body 更新后的招生头条信息
     */
    void update(Headline body);

    /**
     * 管理员端：更新首页招生头条列表
     *
     * @param id 主键
     */
    void delete(int id);

    /**
     * 管理员：查询首页招生头条列表
     *
     * @param pageIndex 页码
     * @param pageSize 页数
     * @param queryHeadline 查询参数
     * @return 招生头条列表
     */
    IPage<Headline> listAdminHeadline(Integer pageIndex, Integer pageSize, QueryHeadlineDto queryHeadline);
}
