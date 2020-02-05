package com.aircos.controller;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dto.CreateEvaluationDto;
import com.aircos.entity.vo.evaluation.EvaluationVo;
import com.aircos.service.EvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
