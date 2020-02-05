package com.aircos.controller;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dao.User;
import com.aircos.entity.dto.UpdateUserDto;
import com.aircos.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of 用户端：用户接口
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-04
 */
@Slf4j
@Api(tags = "UserController", description = "用户端：用户接口")
@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(
            value = "用户信息更改",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PatchMapping("/update")
    public Result update(@RequestBody @Validated UpdateUserDto body) {
        userService.update(body);
        return ResultGenerator.success();
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")
    public Result<User> getUser() {
        return ResultGenerator.success(userService.getUser());
    }
}
