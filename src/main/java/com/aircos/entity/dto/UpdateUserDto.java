package com.aircos.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 修改用户信息
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-04
 */
@ApiModel
@Data
public class UpdateUserDto {

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
    private Integer sourceHistory;

    @ApiModelProperty(value = "英语成绩")
    @TableField(value = "source_english")
    private Integer sourceEnglish;

    @ApiModelProperty(value = "生物成绩")
    @TableField(value = "source_biology")
    private Integer sourceBiology;

    @ApiModelProperty(value = "政治成绩")
    @TableField(value = "source_politics")
    private Integer sourcePolitics;

    @ApiModelProperty(value = "物理成绩")
    @TableField(value = "source_physics")
    private Integer sourcePhysics;

    @ApiModelProperty(value = "语文成绩")
    @TableField(value = "source_chinese")
    private Integer sourceChinese;

    @ApiModelProperty(value = "地理成绩")
    @TableField(value = "source_geography")
    private Integer sourceGeography;

    @ApiModelProperty(value = "化学成绩")
    @TableField(value = "source_chemistry")
    private Integer sourceChemistry;

    @ApiModelProperty(value = "数学成绩")
    @TableField(value = "source_mathematics")
    private Integer sourceMathematics;

    @ApiModelProperty(value = "头像")
    @TableField(value = "head_url")
    private String headUrl;

    @ApiModelProperty(value = "紧急联系人电话")
    @TableField(value = "sos_phone_number")
    private String sosPhoneNumber;
}
