package com.aircos.entity.vo.user;

import com.aircos.core.Date2UnixTimestampSerializer;
import com.aircos.entity.dao.User;
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
public class UserVo extends User {

    @ApiModelProperty(value = "会员状态 true：会员 false：非会员")
    private Boolean userType;
}
