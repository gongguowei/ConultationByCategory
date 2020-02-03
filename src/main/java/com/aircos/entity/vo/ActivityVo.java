package com.aircos.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回给前端的首页轮播图
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@ApiModel
@Data
public class ActivityVo {
    private Integer id;

    @ApiModelProperty(value = "是否显示名称 true:显示 false:不显示")
    private boolean showFlag;

    @ApiModelProperty(value = "轮播图名称")
    private String name;

    @ApiModelProperty(value = "轮播图图片地址")
    private String pictureUrl;
}
