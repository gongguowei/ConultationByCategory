package com.aircos.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

/**
 * 创建专业信息
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-05
 */
@ApiModel
@Data
public class CreateProfessionDto {
    @ApiModelProperty(value = "品类Id")
    private Integer id;

    @ApiModelProperty(value = "品类级别")
    @Range(min = 1,max = 3,message = "品类等级有效值[1,2,3]")
    private Integer level;

    @ApiModelProperty(value = "父级品类id")
    private Integer pid;

    @ApiModelProperty(value = "特殊要求")
    private String need;

    @ApiModelProperty(value = "比例 左文右理 使用“:”分割  AS -> Arts and Sciences")
    private String scaleAs;

    @ApiModelProperty(value = "比例 左男右女 使用“:”分割 ")
    private String scaleSex;

    @ApiModelProperty(value = "对口职业介绍")
    private String workDetail;

    @ApiModelProperty(value = "品类名称")
    private String categoryName;

    @ApiModelProperty(value = "专业介绍")
    private String professionDetail;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", hidden = true)
    private Date updateTime;
}
