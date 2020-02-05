package com.aircos.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 学校查询条件
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-04
 */
@ApiModel
@Data
public class QuerySchoolDto {

    @ApiModelProperty(value = "学校名称")
    private String schoolName;

    @ApiModelProperty(value = "学校地址")
    private String schoolAddress;
}
