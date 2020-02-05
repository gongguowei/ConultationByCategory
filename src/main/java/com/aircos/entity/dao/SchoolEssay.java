package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-02-04
 */
@ApiModel(value = "SchoolEssay", description = "院校招生简章")
@Data
@TableName(value = "aircos_school_essay")
@NoArgsConstructor
public class SchoolEssay {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "aircos_school表主键")
    private Integer schoolId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "正文")
    private String body;

    @ApiModelProperty(value = "创建时间", readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    private Date createTime = new Date();

    @ApiModelProperty(value = "最近更新时间", readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time")
    private Date updateTime = new Date();
}
