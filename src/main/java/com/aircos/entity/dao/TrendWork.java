package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-02-04
 */
@ApiModel(value = "TrendWork", description = "毕业走向-职业")
@Data
@TableName(value = "trend_work")
public class TrendWork {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "aircos_school表主键")
    @TableField(value = "school_id")
    private Integer schoolId;

    @ApiModelProperty(value = "数量")
    @TableField(value = "number")
    private Integer number;

    @ApiModelProperty(value = "职业名称")
    @TableField(value = "work_name")
    private String workName;

    @ApiModelProperty(value = "创建时间", readOnly = true)
    @TableField(value = "create_time")
    private Date createTime = new Date();

    @ApiModelProperty(value = "最近更新时间", readOnly = true)
    @TableField(value = "update_time")
    private Date updateTime = new Date();
}
