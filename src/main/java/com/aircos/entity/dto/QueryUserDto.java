package com.aircos.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 后台管理员查询用户信息
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-04
 */
@ApiModel
@Data
public class QueryUserDto {

    @ApiModelProperty(value = "学生名称")
    private String studentName;

    @ApiModelProperty("手机号码")
    private String phoneNumber;
}
