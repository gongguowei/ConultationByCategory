package com.aircos.controller;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.vo.ActivityVo;
import com.aircos.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller of 首页轮播图
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Slf4j
@Api(tags = "ActivityController", description = "用户端：首页轮播图接口")
@RestController
@RequestMapping("/v1/activity")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @ApiOperation(
            value = "获取首页轮播图",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/list")
    public Result<List<ActivityVo>> list(
            @RequestParam(required = false, defaultValue = "1")Integer pageIndex,
            @RequestParam(required = false, defaultValue = "5")Integer pageSize)
    {
        List<ActivityVo> result = activityService.list(pageIndex, pageSize);
        return ResultGenerator.success(result);
    }

}
