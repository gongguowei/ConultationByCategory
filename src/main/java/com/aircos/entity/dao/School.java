package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
@ApiModel(value = "School", description = "院校")
@Data
@TableName(value = "aircos_school")
public class School {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "院校名称")
    @TableField(value = "school_name")
    private String schoolName;

    @ApiModelProperty(value = "官方网址")
    private String schoolUrl;

    @ApiModelProperty(value = "校园介绍")
    private String schoolInfo;

    @ApiModelProperty(value = "学校联系电话")
    private String schoolPhone;

    @ApiModelProperty(value = "由 省 + 市 + 区 + 详细 拼接的地址，可以为Null")
    private String address;

    @ApiModelProperty(value = "地址-市")
    private String addressCity;

    @ApiModelProperty(value = "地址-详细地址")
    private String addressOther;

    @ApiModelProperty(value = "地址-区")
    private String addressRegion;

    @ApiModelProperty(value = "地址-省")
    private String addressProvince;

    @ApiModelProperty(value = "学校Logo")
    private String pictureLogo;

    @ApiModelProperty(value = "校园风光")
    private String pictureView;

    @ApiModelProperty(value = "创建时间", readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "最近更新时间", readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time")
    private Date updateTime;
}
