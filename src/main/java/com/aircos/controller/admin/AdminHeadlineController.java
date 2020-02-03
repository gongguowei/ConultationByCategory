package com.aircos.controller.admin;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dao.Headline;
import com.aircos.service.HeadlineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of 首页招生头条
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Slf4j
@Api(tags = "AdminHeadlineController", description = "管理员端：首页招生头条接口")
@RestController
@RequestMapping("/v1/admin/headline")
public class AdminHeadlineController {
    private final HeadlineService headlineService;

    @Autowired
    public AdminHeadlineController(HeadlineService headlineService) {
        this.headlineService = headlineService;
    }

    @ApiOperation(
            value = "创建招生头条",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/create")
    public Result create(@RequestBody @Validated Headline body) {
        headlineService.create(body);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "更新招生头条",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/update")
    public Result update(@RequestBody @Validated Headline body) {
        headlineService.update(body);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "删除招生头条",
            authorizations = { @Authorization(value = "jwt")}
    )
    @DeleteMapping("/delete")
    public Result delete(int id) {
        headlineService.delete(id);
        return ResultGenerator.success();
    }
}
