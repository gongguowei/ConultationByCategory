package com.aircos.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回给前端的培训报名列表
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@ApiModel
@Data
public class TrainVo {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "报名状态 0-未开始 1-进行中 2-已结束")
    private Integer applyStatus;

    @ApiModelProperty(value = "aircos_profession表主键")
    private Integer professionId;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "标签")
    private String label;

    @ApiModelProperty(value = "图片地址")
    private String pictureUrl;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

}
