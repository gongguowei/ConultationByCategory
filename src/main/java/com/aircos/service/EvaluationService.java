package com.aircos.service;

import com.aircos.entity.dto.CreateEvaluationDto;
import com.aircos.entity.vo.evaluation.EvaluationVo;

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
}
