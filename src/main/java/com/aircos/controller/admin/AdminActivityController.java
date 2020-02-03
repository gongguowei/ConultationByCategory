package com.aircos.controller.admin;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dao.Activity;
import com.aircos.entity.dto.CreateActivityDto;
import com.aircos.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of 管理员端：首页轮播图接口
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Slf4j
@Api(tags = "ActivityController", description = "管理员端：首页轮播图接口")
@RestController
@RequestMapping("/v1/admin/activity")
public class AdminActivityController {
    private final ActivityService activityService;

    @Autowired
    public AdminActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @ApiOperation(
            value = "创建首页轮播图",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/create")
    public Result create(@RequestBody @Validated CreateActivityDto body) {
        activityService.create(body);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "修改首页轮播图",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PutMapping("/update")
    public Result update(@RequestBody Activity body) {
        activityService.update(body);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "删除首页轮播图",
            authorizations = { @Authorization(value = "jwt")}
    )
    @DeleteMapping("/delete")
    public Result update(@RequestBody int id) {
        activityService.delete(id);
        return ResultGenerator.success();
    }
}
