package com.aircos.controller.admin;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dao.Headline;
import com.aircos.entity.dao.Train;
import com.aircos.entity.dto.QueryHeadlineDto;
import com.aircos.entity.dto.QueryTrainDto;
import com.aircos.service.TrainService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of 管理员端：培训信息接口
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-03
 */
@Slf4j
@Api(tags = "AdminTrainController", description = "管理员端：培训信息接口")
@RestController
@RequestMapping("/v1/admin/train")
public class AdminTrainController {
    private final TrainService trainService;

    @Autowired
    public AdminTrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @ApiOperation(
            value = "创建培训信息",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/create")
    public Result create(@RequestBody @Validated Train body) {
        trainService.create(body);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "获取培训信息",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/list")
    public Result<IPage<Train>> list(
            @RequestParam(required = false, defaultValue = "1")Integer pageIndex,
            @RequestParam(required = false, defaultValue = "5")Integer pageSize,
            @RequestBody QueryTrainDto queryTrain)
    {
        IPage<Train> result = trainService.listAdminTrain(pageIndex, pageSize, queryTrain);
        return ResultGenerator.success(result);
    }
}
