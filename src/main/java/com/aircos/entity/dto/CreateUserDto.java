package com.aircos.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 创建用户
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@ApiModel
@Data
public class CreateUserDto {

    @NotBlank
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;

    @NotBlank
    @ApiModelProperty(value = "短信验证码")
    private String smsCode;

    @NotBlank
    @ApiModelProperty(value = "密码, 使用SHA-256 + 随机盐 + 密钥加密", required = true)
    private String password;

    @NotBlank
    @ApiModelProperty(value = "确认密码, 使用SHA-256 + 随机盐 + 密钥加密", required = true)
    private String confirmPassword;

    @NotBlank
    @ApiModelProperty(value = "昵称", required = true)
    private String nickName;

    @NotBlank
    @ApiModelProperty(value = "就读学校", required = true)
    private String schoolName;

    @NotBlank
    @ApiModelProperty(value = "就读地区")
    private String schoolAddress;

    @NotBlank
    @ApiModelProperty(value = "就读科目", required = true)
    private String studySubject;
}
