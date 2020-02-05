package com.aircos.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询培训信息
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-04
 */
@Data
@ApiModel
public class QueryTrainDto {
    @ApiModelProperty(value = "报名状态 0-未开始 1-进行中 2-已结束")
    private Integer applyStatus;

    @ApiModelProperty(value = "标题")
    private String title;
}
