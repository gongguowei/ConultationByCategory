package com.aircos.controller;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.vo.TrainVo;
import com.aircos.service.TrainService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of 培训
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Slf4j
@Api(tags = "TrainController", description = "用户端：培训信息")
@RestController
@RequestMapping("/v1/train")
public class TrainController {

    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @ApiOperation(
            value = "用户端：获取培训信息",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/list")
    public Result<IPage<TrainVo>> list(
            @RequestParam(required = false, defaultValue = "1")Integer pageIndex,
            @RequestParam(required = false, defaultValue = "5")Integer pageSize)
    {
        IPage<TrainVo> result = trainService.list(pageIndex, pageSize);
        return ResultGenerator.success(result);
    }
}
