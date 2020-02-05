package com.aircos.controller;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dto.QuerySchoolDto;
import com.aircos.entity.vo.SchoolAreaVo;
import com.aircos.entity.vo.SchoolProfessionVo;
import com.aircos.entity.vo.SchoolVo;
import com.aircos.service.SchoolService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Controller of 学校
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-03
 */
@Slf4j
@Api(tags = "SchoolController", description = "用户端：爱校园模块")
@RestController
@RequestMapping("/v1/school")
public class SchoolController {

    @Resource
    private SchoolService schoolService;

    @ApiOperation(
            value = "用户端：获取学校对应的专业",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/query")
    public Result<SchoolProfessionVo> query(int schoolId) {
        SchoolProfessionVo result = schoolService.query(schoolId);
        return ResultGenerator.success(result);
    }

    @ApiOperation(
            value = "用户端：获取头部学校地区分类",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/category")
    public Result<List<SchoolAreaVo>> category() {
        List<SchoolAreaVo> result = schoolService.queryCategory();
        return ResultGenerator.success(result);
    }

    @ApiOperation(
            value = "用户端：根据查询条件获取学校列表",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/list")
    public Result<IPage<SchoolVo>> list(
            @RequestParam(required = false, defaultValue = "1")Integer pageIndex,
            @RequestParam(required = false, defaultValue = "5")Integer pageSize,
            @RequestBody QuerySchoolDto querySchool) {
        IPage<SchoolVo> result = schoolService.listUserSchool(pageIndex, pageSize, querySchool);
        return ResultGenerator.success(result);
    }
}
