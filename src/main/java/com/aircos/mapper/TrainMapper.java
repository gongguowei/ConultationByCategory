package com.aircos.mapper;

import com.aircos.entity.dao.Train;
import com.aircos.entity.vo.TrainVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Repository;

/**
 * Mapper of 培训报名
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Repository
public interface TrainMapper extends BaseMapper<Train> {

    /**
     * 获取指定数据的培训报名信息列表
     *
     * @param page 分页信息
     * @return 培训报名列表
     */
    IPage<TrainVo> queryTrainListByPage(IPage<TrainVo> page);
}
