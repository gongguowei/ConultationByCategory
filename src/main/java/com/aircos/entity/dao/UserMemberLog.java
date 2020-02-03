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
@ApiModel(value = "user_member_log", description = "用户会员充值历史")
@TableName("user_member_log")
public class UserMemberLog implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "User表主键")
    @TableField(value = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "生效时间")
    @TableField(value = "start_time")
    private Date startTime;

    @ApiModelProperty(value = "失效时间")
    @TableField(value = "end_time")
    private Date endTime;

    @ApiModelProperty(value = "充值类型: 偏移的月")
    private Integer type;

    @ApiModelProperty(value = "钱 单位分")
    private Integer money;

    @ApiModelProperty(value = "删除标识 0,null不是删除; 1-删除")
    private Integer delFlag;

    public static final String ID = "id";
    public static final String USER_ID = "user_id";
    public static final String DEL_FLAG = "del_flag";
    public static final String END_TIME = "end_time";
}
