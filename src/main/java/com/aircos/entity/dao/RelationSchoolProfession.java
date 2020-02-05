package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-02-04
 */
@ApiModel(value = "RelationSchoolProfession", description = "关系表-学校与专业")
@Data
@TableName(value = "relation_school_profession")
public class RelationSchoolProfession {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "aircos_schoolId表主键")
    private Integer schoolId;

    @ApiModelProperty(value = "aircos_profession表主键")
    private Integer professionId;

    @ApiModelProperty(value = "计划招生人数")
    private Integer enrolment;

    @ApiModelProperty(value = "创建时间", readOnly = true)
    @TableField(value = "create_time")
    private Date createTime = new Date();

    @ApiModelProperty(value = "最近更新时间", readOnly = true)
    @TableField(value = "update_time")
    private Date updateTime = new Date();
}
