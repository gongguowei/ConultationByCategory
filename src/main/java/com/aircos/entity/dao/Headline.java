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
 * @since 2020-02-02
 */
@ApiModel(value = "Headline", description = "首页-招生头条")
@Data
@TableName(value = "aircos_headline")
public class Headline {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "创建用户主键")
    private Integer createUid;

    @NotBlank(message = "正文不能为空")
    @ApiModelProperty(value = "正文")
    private String body;

    @NotBlank(message = "标题不能为空")
    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "分类")
    private String category;

    @ApiModelProperty(value = "图片地址")
    private String pictureUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间", hidden = true)
    private Date updateTime;
}
