package com.aircos.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回给前端的 爱校园模块-头部地区列表
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-05
 */
@ApiModel
@Data
public class SchoolAreaVo {

    @ApiModelProperty(value = "地区")
    private String addressCity;
}
