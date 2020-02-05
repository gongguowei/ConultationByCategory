package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-02-04
 */
@ApiModel(value = "TrendSurvey", description = "毕业走向-概述")
@Data
@TableName(value = "trend_survey")
@NoArgsConstructor
public class TrendSurvey {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "aircos_school表主键")
    @TableField(value = "school_id")
    private Integer schoolId;

    @ApiModelProperty(value = "毕业生五年薪资(元)")
    private Integer salaryFive;

    @ApiModelProperty(value = "毕业生薪酬排位薪资(元)")
    private Integer salaryRank;

    @ApiModelProperty(value = "毕业生最多去向行业")
    private String work;

    @ApiModelProperty(value = "毕业生最多去向城市")
    private String city;

    @ApiModelProperty(value = "创建时间", readOnly = true)
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "最近更新时间", readOnly = true)
    @TableField(value = "update_time")
    private Date updateTime;
}
