package com.aircos.mapper;

import com.aircos.entity.dao.Headline;
import com.aircos.entity.vo.HeadlineVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Repository;

/**
 * Mapper of 首页-招生头条
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Repository
public interface HeadlineMapper extends BaseMapper<Headline> {

    /**
     * 返回指定格式的首页招生头条列表
     *
     * @param page 分页信息
     * @return 招生头条
     */
    IPage<HeadlineVo> queryHeadlinesByPage(IPage<HeadlineVo> page);
}
