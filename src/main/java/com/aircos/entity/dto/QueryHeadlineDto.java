package com.aircos.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 首页招生头条查询信息
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@ApiModel
@Data
public class QueryHeadlineDto {

    @NotNull(message = "招生头条主键不能为Null!")
    @ApiModelProperty(value = "招生头条主键")
    private Integer id;
}
