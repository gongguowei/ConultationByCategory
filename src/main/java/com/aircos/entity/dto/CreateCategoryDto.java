package com.aircos.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;


/**
 * 创建品类
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Data
public class CreateCategoryDto {
    @ApiModelProperty(value = "品类Id")
    private Integer id;

    @ApiModelProperty(value = "品类级别")
    @Range(min = 1,max = 3,message = "品类等级有效值[1,2,3]")
    private Integer level;

    @ApiModelProperty(value = "父级品类id")
    private Integer pid;

    @ApiModelProperty(value = "品类名称")
    private String  categoryName;
}
