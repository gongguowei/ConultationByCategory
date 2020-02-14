package com.aircos.mapper;

import com.aircos.core.mybatis.base.MyBaseMapper;
import com.aircos.entity.dao.WaitingOption;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper of 问题答案待选项
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-09
 */
@Repository
public interface WaitingOptionMapper extends MyBaseMapper<WaitingOption> {

    /**
     * 配合XML，通过问题Id查询问题待选项
     *
     * @param questionId 问题ID
     * @return 问题待选项
     */
    List<WaitingOption> queryWaitingOptionByQuestionId(Integer questionId);
}
