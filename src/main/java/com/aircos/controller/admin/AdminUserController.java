package com.aircos.controller.admin;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dto.CreateUserDto;
import com.aircos.entity.dto.QueryUserDto;
import com.aircos.entity.vo.user.UserVo;
import com.aircos.service.RedisService;
import com.aircos.service.UserService;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * Controller of 管理员端：用户
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@Slf4j
@Api(tags = "AdminUserController", description = "管理员端：用户接口")
@RestController
@RequestMapping("/v1/admin/user")
public class AdminUserController {

    private final UserService userService;

    private final RedisService redisService;

    @Autowired
    public AdminUserController(UserService userService, RedisService redisService) {
        this.userService = userService;
        this.redisService = redisService;
    }

    @ApiOperation(
            value = "创建用户",
            authorizations = { @Authorization(value = "jwt")}
    )
    @PostMapping("/create")
    public Result<Integer> createUser(@RequestBody @Validated CreateUserDto body) {
        String codeVal = redisService.getCodeVal(body.getPhone());
        if (body.getSmsCode().equals(codeVal)) {
            int user = userService.createUser(body);
            return ResultGenerator.success(user);
        } else {
            return ResultGenerator.failure("验证码输入有误");
        }
    }

    @ApiOperation(value = "批量获取用户信息")
    @PostMapping("/infos")
    public Result<IPage<UserVo>> listUsers(
        @RequestParam("pageIndex") Integer pageIndex,
        @RequestParam("pageSize") Integer pageSize,
        @RequestBody QueryUserDto query) {
        return ResultGenerator.success(userService.listUsers(pageIndex, pageSize, query));
    }

    @ApiOperation(
            value = "发送注册用户短信验证码",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/sendSms")
    public Result sendRegisterCode(@RequestParam("phone") String phone) throws ClientException {
        userService.sendRegisterCode(phone);
        return ResultGenerator.success();
    }
}
