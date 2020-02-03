package com.aircos.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 返回给前端的首页招生头条
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@ApiModel
@Data
public class HeadlineVo {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "分类")
    private String category;

    @ApiModelProperty(value = "图片地址")
    private String pictureUrl;

    @ApiModelProperty(value = "发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
