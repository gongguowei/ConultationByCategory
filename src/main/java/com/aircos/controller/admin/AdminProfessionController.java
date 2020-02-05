package com.aircos.controller.admin;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dto.CreateProfessionDto;
import com.aircos.service.ProfessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of 专业接口
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-05
 */
@Slf4j
@Api(tags = "AdminProfessionController", description = "管理员端：专业接口")
@RestController
@RequestMapping("/v1/admin/profession")
public class AdminProfessionController {
    private final ProfessionService professionService;

    @Autowired
    public AdminProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @ApiOperation(
            value = "创建专业信息",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/create")
    public Result create(@RequestBody CreateProfessionDto body) {
        professionService.create(body);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "更新专业信息",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PatchMapping("/update")
    public Result update(@RequestBody CreateProfessionDto body) {
        professionService.update(body);
        return ResultGenerator.success();
    }

    @ApiOperation(
            value = "删除专业信息",
            authorizations = { @Authorization(value = "jwt")}
    )
    @DeleteMapping("/delete")
    public Result delete(@RequestParam("id") int id,
                         @RequestParam("level") int level) {
        professionService.delete(id, level);
        return ResultGenerator.success();
    }
}
