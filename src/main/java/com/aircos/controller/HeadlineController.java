package com.aircos.controller;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dao.Headline;
import com.aircos.entity.dto.QueryHeadlineDto;
import com.aircos.entity.vo.HeadlineVo;
import com.aircos.service.HeadlineService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Controller of 首页- 招生头条
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Slf4j
@Api(tags = "HeadlineController", description = "用户端：首页- 招生头条接口")
@RestController
@RequestMapping("/v1/headline")
public class HeadlineController {

    private final HeadlineService headlineService;

    @Autowired
    public HeadlineController(HeadlineService headlineService) {
        this.headlineService = headlineService;
    }

    @ApiOperation(
            value = "获取首页- 招生头条",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/list")
    public Result<IPage<HeadlineVo>> list(
            @RequestParam(required = false, defaultValue = "1")Integer pageIndex,
            @RequestParam(required = false, defaultValue = "5")Integer pageSize)
    {
        IPage<HeadlineVo> result = headlineService.list(pageIndex, pageSize);
        return ResultGenerator.success(result);
    }

    @ApiOperation(
            value = "获取首页- 招生头条详情",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/detail")
    public Result<Headline> detail(@RequestBody QueryHeadlineDto query) {
        Headline result = headlineService.detail(query);
        return ResultGenerator.success(result);
    }

}
