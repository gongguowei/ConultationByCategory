package com.aircos.service;

import com.aircos.entity.vo.ProfessionDetailVo;
import com.aircos.entity.vo.QueryProfessionVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * Interface of 专业
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
public interface ProfessionService {

    /**
     * 用户端：获取专业详情
     *
     * @param professionId 主键
     * @return 专业详情
     */
    ProfessionDetailVo list(int professionId);

    /**
     * 用户端：根据关键字获取专业
     *
     * @param keyWord 关键字
     * @param pageIndex 页码
     * @param pageSize 页数
     * @return 专业列表
     */
    IPage<QueryProfessionVo> query(String keyWord, Integer pageIndex, Integer pageSize);
}
