package com.aircos.entity.vo.user;

import com.aircos.core.Date2UnixTimestampSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 返回给前端的用户对象
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@ApiModel
@Data
public class UserVo {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String headUrl;

    @ApiModelProperty(value = "创建时间", readOnly = true)
    @JsonSerialize(using = Date2UnixTimestampSerializer.class)
    private Date createTime;

    @ApiModelProperty(value = "最近更新时间", readOnly = true)
    @JsonSerialize(using = Date2UnixTimestampSerializer.class)
    private Date updateTime;
}
