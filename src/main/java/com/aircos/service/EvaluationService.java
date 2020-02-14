package com.aircos.service;

import com.aircos.entity.dto.CreateEvaluationDto;
import com.aircos.entity.vo.evaluation.EvaluationVo;
import com.aircos.entity.vo.evaluation.QuestionVo;

import java.util.List;

/**
 * Interface of 专业倾向测评
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
public interface EvaluationService {

    /**
     * 创建专业倾向测评
     *
     * @param body 专业测评判断条件
     * @return 专业倾向测评结果: 适合我的专业 + 适合我的学校
     */
    EvaluationVo createEvaluation(CreateEvaluationDto body);

    /**
     * 获取专业倾向的问题
     *
     * @param questionType 1:了解性格方面的问题 2:了解兴趣方面的问题
     * @return 问题
     */
    List<QuestionVo> listQuestion(int questionType);
}
