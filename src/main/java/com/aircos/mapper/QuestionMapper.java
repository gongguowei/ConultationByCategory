package com.aircos.mapper;

import com.aircos.core.mybatis.base.MyBaseMapper;
import com.aircos.entity.dao.Question;
import com.aircos.entity.vo.evaluation.QuestionVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper of 设置问题
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-09
 */
@Repository
public interface QuestionMapper extends MyBaseMapper<Question> {

    /**
     * 获取指定问题类型+问题候选项
     *
     * @param questionType 问题类型
     * @return 问题列表+问题候选项
     */
    List<QuestionVo> listQuestions(@Param("questionType") int questionType);
}
