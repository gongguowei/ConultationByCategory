package com.aircos.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "user_member_money", description = "用户会员充值总额表")
@TableName("user_member_money")
public class UserMemberMoney implements Serializable {

    public static final String ID = "id";

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @ApiModelProperty(value = "总的充值金额 单位分")
    private Integer money;

    @ApiModelProperty(value = "是否是会员 true:会员 false:非会员")
    @TableField("is_member")
    private Boolean isMember;

    @ApiModelProperty(value = "最后一次充值的时间")
    @TableField("last_time")
    private Date lastTime;
}