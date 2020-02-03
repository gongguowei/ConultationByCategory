package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@ApiModel(value = "Category", description = "专业品类")
@Data
@TableName(value = "aircos_category")
public class Category {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "品类名称")
    @Column(name = "category_name")
    private String categoryName;

    @ApiModelProperty(value = "创建者用户ID")
    @Column(name = "create_uid")
    private Integer createUid;

    @ApiModelProperty(value = "是否删除")
    @Column(name = "is_deleted true:删除 false:未删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "品类分级")
    private Integer level;

    @ApiModelProperty(value = "父级")
    private Integer pid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间", hidden = true)
    private Date updateTime;
}
