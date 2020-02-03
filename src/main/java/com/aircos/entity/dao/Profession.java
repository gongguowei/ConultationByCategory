package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
@ApiModel(value = "Profession", description = "专业")
@Data
@TableName(value = "aircos_profession")
public class Profession {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "创建用户主键")
    private Integer createUid;

    @NotBlank(message = "专业名称不能为空")
    @ApiModelProperty(value = "专业名称")
    private String name;

    @ApiModelProperty(value = "特殊要求")
    private String need;

    @ApiModelProperty(value = "比例 左文右理 使用“:”分割  AS -> Arts and Sciences")
    private String scaleAs;

    @ApiModelProperty(value = "比例 左男右女 使用“:”分割 ")
    private String scaleSex;

    @ApiModelProperty(value = "对口职业介绍")
    private String workDetail;

    @ApiModelProperty(value = "专业介绍")
    private String professionDetail;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", hidden = true)
    private Date updateTime;
}
