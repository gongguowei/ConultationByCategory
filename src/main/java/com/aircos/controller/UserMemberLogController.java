package com.aircos.controller;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dao.UserMemberLog;
import com.aircos.service.UserMemberLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of Vip充值日志
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
@Slf4j
@Api(tags = "UserMemberLogController", description = "Vip充值日志接口")
@RestController
@RequestMapping("/v1/vip")
public class UserMemberLogController {

    private final UserMemberLogService userMemberLogService;

    @Autowired
    public UserMemberLogController(UserMemberLogService userMemberLogService) {
        this.userMemberLogService = userMemberLogService;
    }

    @ApiOperation(
            value = "添加一个VIP支付成功记录",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/create")
    public Result<Integer> create(@RequestBody @Validated UserMemberLog body) {
        boolean result = userMemberLogService.create(body);
        if (!result) {
            return ResultGenerator.failure("添加失败");
        }
        return ResultGenerator.success();
    }

    @ApiOperation(value = "查询当前用户是否是会员",
                  notes = "true:是会员，false不是会员")
    @GetMapping("/check")
    public Result<Boolean> checkUserMember() {
        return ResultGenerator.success(userMemberLogService.checkUserMember());
    }
}
