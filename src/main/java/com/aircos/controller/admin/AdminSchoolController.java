package com.aircos.controller.admin;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dao.Headline;
import com.aircos.entity.dao.School;
import com.aircos.entity.dao.Train;
import com.aircos.entity.dto.CreateSchoolDto;
import com.aircos.entity.dto.QueryHeadlineDto;
import com.aircos.entity.dto.QuerySchoolDto;
import com.aircos.service.SchoolService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of 管理员端：院校接口
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-04
 */
@Slf4j
@Api(tags = "AdminSchoolController", description = "管理员端：院校接口")
@RestController
@RequestMapping("/v1/admin/school")
public class AdminSchoolController {

    private final SchoolService schoolService;

    @Autowired
    public AdminSchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @ApiOperation(
            value = "创建院校信息",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/create")
    public Result create(@RequestBody CreateSchoolDto body) {
        schoolService.create(body);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "获取院校信息",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/list")
    public Result<IPage<School>> list(
            @RequestParam(required = false, defaultValue = "1")Integer pageIndex,
            @RequestParam(required = false, defaultValue = "5")Integer pageSize,
            @RequestBody QuerySchoolDto querySchool)
    {
        IPage<School> result = schoolService.listAdminSchool(pageIndex, pageSize, querySchool);
        return ResultGenerator.success(result);
    }


}
