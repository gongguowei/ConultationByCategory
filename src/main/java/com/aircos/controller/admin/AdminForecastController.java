package com.aircos.controller.admin;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dao.Question;
import com.aircos.entity.dao.WaitingOption;
import com.aircos.entity.dto.QueryQuestionDto;
import com.aircos.service.ForecastService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller of 管理员端：预测模块问题答案设置接口
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-09
 */
@Slf4j
@Api(tags = "AdminForecastController", description = "管理员端：预测模块问题答案设置接口")
@RestController
@RequestMapping("/v1/admin/forecast")
public class AdminForecastController {

    @Autowired
    private ForecastService forecastService;

    @ApiOperation(
            value = "管理员端：创建问题",
            notes = "questionType: 1:了解性格方面的问题 2:了解兴趣方面的问题",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/create/question")
    public Result createQuestion(@RequestBody @Validated List<Question> body) {
        forecastService.createQuestion(body);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "管理员端：创建问题回答待选项",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/create/wait")
    public Result createWait(@RequestBody @Validated List<WaitingOption> body) {
        forecastService.createWait(body);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "管理员端：获取问题",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/list/question")
    public Result<IPage<Question>> listQuestion(
            @RequestParam(required = false, defaultValue = "1")Integer pageIndex,
            @RequestParam(required = false, defaultValue = "5")Integer pageSize,
            @RequestBody @Validated QueryQuestionDto query
            ) {
        IPage<Question> result = forecastService.list(pageIndex, pageSize, query);
        return ResultGenerator.success(result);
    }

    @ApiOperation(
            value = "管理员端：获取问题回答待选项",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/list/wait")
    public Result<List<WaitingOption>> listWait(@RequestParam Integer questionId) {
        List<WaitingOption> result = forecastService.listWait(questionId);
        return ResultGenerator.success(result);
    }

    @ApiOperation(
            value = "管理员端：删除问题",
            notes = "删除问题会将改问题下的待选项全部删除",
            authorizations = { @Authorization(value = "jwt")}
    )
    @DeleteMapping("/delete/question")
    public Result deleteQuestion(int id) {
        forecastService.deleteQuestion(id);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "管理员端：删除问题回答待选项",
            authorizations = { @Authorization(value = "jwt")}
    )
    @DeleteMapping("/delete/wait")
    public Result deleteWait(int id) {
        forecastService.deleteWait(id);
        return ResultGenerator.success();
    }

    /**
     * 部分浏览器暂时不支持 Patching请求
     */
    @ApiOperation(
            value = "管理员端：更新问题",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PutMapping("/update/question")
    public Result updateQuestion(@RequestBody @Validated Question body) {
        forecastService.updateQuestion(body);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "管理员端：更新问题答案待选项",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PutMapping("/update/wait")
    public Result updateWait(@RequestBody @Validated WaitingOption body) {
        forecastService.updateWait(body);
        return ResultGenerator.success();
    }
}
