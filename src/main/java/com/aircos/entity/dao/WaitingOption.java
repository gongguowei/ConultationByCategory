package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-02-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "waitingOption", description = "问题答案待选项")
@TableName("waiting_option")
public class WaitingOption {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @NotBlank
    @ApiModelProperty(value = "aircos_question表主键")
    private Integer questionId;

    @NotBlank
    @ApiModelProperty(value = "选项内容")
    private String detail;

    @ApiModelProperty(value = "设置选项序号，例如A B C D")
    private String options;

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
