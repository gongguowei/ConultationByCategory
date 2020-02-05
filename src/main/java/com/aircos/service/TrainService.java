package com.aircos.service;

import com.aircos.entity.dao.Train;
import com.aircos.entity.dto.QueryTrainDto;
import com.aircos.entity.vo.TrainVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * Interface of 培训信息
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
public interface TrainService {

    /**
     * 用户端：获取培训信息列表
     *
     * @param pageIndex 页码
     * @param pageSize 页数
     * @return 培训信息列表
     */
    IPage<TrainVo> list(Integer pageIndex, Integer pageSize);

    /**
     * 管理端：创建培训信息
     *
     * @param body 培训信息
     */
    void create(Train body);

    /**
     * 管理端：获取培训信息
     *
     * @param pageIndex 页码
     * @param pageSize 页数
     * @param queryTrain 查询参数
     * @return
     */
    IPage<Train> listAdminTrain(Integer pageIndex, Integer pageSize, QueryTrainDto queryTrain);
}
