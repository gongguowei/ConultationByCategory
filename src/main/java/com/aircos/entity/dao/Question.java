package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-02-09
 */
@ApiModel(value = "Question", description = "问题表")
@Data
@TableName(value = "aircos_question")
public class Question {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @Range(max = 2, min = 1, message = "请指明类型，1:了解性格方面的问题 2:了解兴趣方面的问题")
    @ApiModelProperty(value = "1:了解性格 2:了解兴趣")
    private Integer questionType;

    @NotBlank(message = "问题内容不能为空。")
    @ApiModelProperty(value = "问题内容")
    private String question;

    /**
     * 这里初始化new Date的原因是Mybatis-plus选装件'批量插入',必须有一个字段都有默认初始化值
     */
    @ApiModelProperty(value = "创建时间", readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    private Date createTime = new Date();

    @ApiModelProperty(value = "最近更新时间", readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time")
    private Date updateTime = new Date();

}
