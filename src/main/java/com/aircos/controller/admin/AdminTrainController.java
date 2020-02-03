package com.aircos.controller.admin;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dao.Train;
import com.aircos.service.TrainService;
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
}
