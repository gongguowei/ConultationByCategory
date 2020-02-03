package com.aircos.controller.admin;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dto.CreateUserDto;
import com.aircos.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller of 用户
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@Slf4j
@Api(tags = "AdminUserController", description = "用户接口")
@RestController
@RequestMapping("/v1/user")
public class AdminUserController {

    private final UserService userService;

    @Autowired
    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(
            value = "创建用户",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/create")
    public Result<Integer> createUser(@RequestBody @Validated CreateUserDto body) {
        int user = userService.createUser(body);
        return ResultGenerator.success(user);
    }
}
