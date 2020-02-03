package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Data
@ApiModel(value = "ProfessionLog", description = "专业搜索日志")
@TableName(value = "log_profession")
@NoArgsConstructor
public class ProfessionLog implements Serializable {

    @TableId
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "请求耗时")
    private Long time;

    @ApiModelProperty(value = "参数")
    private String param;

    @ApiModelProperty(value = "方法名")
    private String method;

    @ApiModelProperty(value = "请求IP地址")
    private String requestIp;

    @ApiModelProperty(value = "描述")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date updateTime;
}