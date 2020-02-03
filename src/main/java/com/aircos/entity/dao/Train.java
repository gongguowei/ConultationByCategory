package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@ApiModel(value = "Train", description = "培训信息表")
@Data
@Builder
@TableName(value = "aircos_train")
public class Train {

    public static final String ID = "id";

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "报名状态 0-未开始 1-进行中 2-已结束")
    private Integer applyStatus;

    @ApiModelProperty(value = "aircos_profession表主键")
    private Integer professionId;

    @ApiModelProperty(value = "价格")
    @NotNull(message = "价格不能为Null！")
    private Double price;

    @ApiModelProperty(value = "是否删除")
    @Column(name = "is_deleted true:删除 false:未删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "标题")
    @NotNull(message = "标题不能为Null！")
    private String title;

    @ApiModelProperty(value = "标签")
    private String label;

    @ApiModelProperty(value = "商品编码")
    private String productId;

    @ApiModelProperty(value = "地区名称")
    private String areaName;

    @ApiModelProperty(value = "图片地址")
    private String pictureUrl;

    @ApiModelProperty(value = "结束时间")
    @NotNull(message = "结束时间不能为Null!")
    private Date endTime;

    @ApiModelProperty(value = "开始时间")
    @NotNull(message = "开始时间不能为Null!")
    private Date startTime;

    @ApiModelProperty(value = "创建时间", readOnly = true)
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "最近更新时间", readOnly = true)
    @TableField(value = "update_time")
    private Date updateTime;
}
