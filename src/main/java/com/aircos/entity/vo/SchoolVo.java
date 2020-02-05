package com.aircos.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回给前端的 爱校园模块-校园列表
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-05
 */
@ApiModel
@Data
public class SchoolVo {

    @ApiModelProperty(value = "学校主键")
    private Integer id;

    @ApiModelProperty(value = "学校Logo")
    private String schoolLogo;

    @ApiModelProperty(value = "学校名称")
    private String schoolName;

    @ApiModelProperty(value = "学校地址")
    private String schoolAddress;

}
