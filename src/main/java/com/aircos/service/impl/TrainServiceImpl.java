package com.aircos.service.impl;

import cn.hutool.core.util.IdUtil;
import com.aircos.entity.dao.Train;
import com.aircos.entity.dto.QueryTrainDto;
import com.aircos.entity.vo.TrainVo;
import com.aircos.mapper.TrainMapper;
import com.aircos.service.TrainService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service of 培训报名
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Service
public class TrainServiceImpl implements TrainService {

    private final TrainMapper trainMapper;

    @Autowired
    public TrainServiceImpl(TrainMapper trainMapper) {
        this.trainMapper = trainMapper;
    }

    @Override
    public IPage<TrainVo> list(Integer pageIndex, Integer pageSize) {
        IPage<TrainVo> page = new Page(pageIndex, pageSize);
        return trainMapper.queryTrainListByPage(page);
    }

    @Override
    public void create(Train body) {
        body.setProductId(IdUtil.simpleUUID());
        trainMapper.insert(body);
    }

    @Override
    public IPage<Train> listAdminTrain(Integer pageIndex, Integer pageSize, QueryTrainDto queryTrain) {
        IPage<Train> page = new Page(pageIndex, pageSize);
        return trainMapper.selectPage(page, new QueryWrapper<Train>()
                .lambda()
                .like(null != queryTrain.getTitle(), Train::getTitle, queryTrain.getTitle())
                .eq(null != queryTrain.getApplyStatus(), Train::getApplyStatus, queryTrain.getApplyStatus()));
    }
}
