package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@ApiModel(value = "User", description = "用户")
@Data
@TableName(value = "aircos_user")
public class User {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "留学意向 1：有 2：没有 3：考虑中")
    @TableField(value = "study_out")
    private Integer studyOut;

    @ApiModelProperty(value = "QQ号")
    @TableField(value = "qq_number")
    private Integer qqNumber;

    @ApiModelProperty(value = "考虑专家服务 1：有考虑 2：没有考虑 3：其他")
    @TableField(value = "expert_service")
    private Integer expertService;

    @ApiModelProperty(value = "语文成绩")
    @TableField(value = "source_chinese")
    private Integer sourceChinese;

    @ApiModelProperty(value = "数学成绩")
    @TableField(value = "source_mathematics")
    private Integer sourceMathematics;

    @ApiModelProperty(value = "头像")
    @TableField(value = "head_url")
    private String headUrl;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    @TableField(value = "nick_name")
    private String nickName;

    @ApiModelProperty(value = "就读学校")
    @TableField(value = "school_name")
    private String schoolName;

    @ApiModelProperty(value = "就读科目")
    @TableField(value = "study_subject")
    private String studySubject;

    @ApiModelProperty(value = "手机号")
    @TableField(value = "phone_number")
    private String phoneNumber;

    @ApiModelProperty(value = "创建时间", readOnly = true)
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "最近更新时间", readOnly = true)
    @TableField(value = "update_time")
    private Date updateTime;
}
