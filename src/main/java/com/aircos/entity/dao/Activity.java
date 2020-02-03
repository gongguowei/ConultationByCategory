package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@ApiModel(value = "Activity", description = "首页轮播图")
@Data
@TableName(value = "aircos_activity")
public class Activity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "排序")
    private Integer seq;

    @ApiModelProperty(value = "创建者ID")
    private Integer createId;

    @ApiModelProperty(value = "关联地址")
    private String relUrl;

    @NotNull
    @ApiModelProperty(value = "轮播图名称")
    private String name;

    @NotNull
    @ApiModelProperty(value = "图片地址")
    private String pictureUrl;

    @ApiModelProperty(value = "是否启用 true 启用 false 不启用")
    @TableField(value = "`use`")
    private Boolean use;

    @ApiModelProperty(value = "是否显示名称 true 显示 false 不显示")
    private Boolean showName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间", hidden = true)
    private Date updateTime;
}
