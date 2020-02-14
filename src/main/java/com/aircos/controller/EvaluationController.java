package com.aircos.controller;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dto.CreateEvaluationDto;
import com.aircos.entity.vo.evaluation.EvaluationVo;
import com.aircos.entity.vo.evaluation.QuestionVo;
import com.aircos.service.EvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller of 专业倾向测评
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@Slf4j
@Api(tags = "EvaluationController", description = "专业倾向测评接口")
@RestController
@RequestMapping("/v1/valuation")
public class EvaluationController {

    private final EvaluationService evaluationService;

    @Autowired
    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @ApiOperation(
            value = "获取专业倾向测评结果",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/create")
    public Result<EvaluationVo> createEvaluation(@RequestBody @Validated CreateEvaluationDto body) {
        EvaluationVo result = evaluationService.createEvaluation(body);
        return ResultGenerator.success(result);
    }

    @ApiOperation(
            value = "获取专业倾向的问题 + 问题选项",
            notes = "questionType: 1:了解性格方面的问题 2:了解兴趣方面的问题",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/list/question")
    public Result<List<QuestionVo>> listQuestion(int questionType) {
        List<QuestionVo> result = evaluationService.listQuestion(questionType);
        return ResultGenerator.success(result);
    }
}
