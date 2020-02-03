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

    @ApiModelProperty(value = "最低录取分数, 根据用户总分过滤不满足条件的院校")
    @TableField(value = "source_min")
    private Integer sourceMin;

    @ApiModelProperty(value = "院校名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "地址")
    private String schoolAddress;

    @ApiModelProperty(value = "创建时间", readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "最近更新时间", readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time")
    private Date updateTime;
}
