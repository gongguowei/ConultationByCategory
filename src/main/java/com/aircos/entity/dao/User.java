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

    @ApiModelProperty(value = "性别 1：男 2：女 3：未知")
    private Integer sex;

    @ApiModelProperty(value = "留学意向 1：有 2：没有 3：考虑中")
    @TableField(value = "study_out")
    private Integer studyOut;

    @ApiModelProperty(value = "QQ号")
    @TableField(value = "qq_number")
    private Integer qqNumber;

    @ApiModelProperty(value = "考虑专家服务 1：有考虑 2：没有考虑 3：其他")
    @TableField(value = "expert_service")
    private Integer expertService;

    @ApiModelProperty(value = "历史成绩")
    @TableField(value = "source_history")
    private String sourceHistory;

    @ApiModelProperty(value = "英语成绩")
    @TableField(value = "source_english")
    private String sourceEnglish;

    @ApiModelProperty(value = "生物成绩")
    @TableField(value = "source_biology")
    private String sourceBiology;

    @ApiModelProperty(value = "政治成绩")
    @TableField(value = "source_politics")
    private String sourcePolitics;

    @ApiModelProperty(value = "物理成绩")
    @TableField(value = "source_physics")
    private String sourcePhysics;

    @ApiModelProperty(value = "语文成绩")
    @TableField(value = "source_chinese")
    private String sourceChinese;

    @ApiModelProperty(value = "地理成绩")
    @TableField(value = "source_geography")
    private String sourceGeography;

    @ApiModelProperty(value = "化学成绩")
    @TableField(value = "source_chemistry")
    private String sourceChemistry;

    @ApiModelProperty(value = "信息技术成绩")
    @TableField(value = "source_information")
    private String sourceInformation;

    @ApiModelProperty(value = "通用技术成绩")
    @TableField(value = "general_technology")
    private String generalTechnology;

    @ApiModelProperty(value = "数学成绩")
    @TableField(value = "source_mathematics")
    private String sourceMathematics;

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

    @ApiModelProperty(value = "就读地址")
    @TableField(value = "school_address")
    private String schoolAddress;

    @ApiModelProperty(value = "手机号")
    @TableField(value = "phone_number")
    private String phoneNumber;

    @ApiModelProperty(value = "紧急联系人电话")
    @TableField(value = "sos_phone_number")
    private String sosPhoneNumber;

    @ApiModelProperty(value = "创建时间", readOnly = true)
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "最近更新时间", readOnly = true)
    @TableField(value = "update_time")
    private Date updateTime;
}
