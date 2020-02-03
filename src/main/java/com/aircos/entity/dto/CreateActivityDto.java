package com.aircos.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Data
public class CreateActivityDto {
    @ApiModelProperty(value = "活动Id")
    private Integer id;

    @Min(1)
    @ApiModelProperty(value = "活动顺序")
    private Integer seq;

    @NotBlank(message = "活动名称不能为空")
    @ApiModelProperty(value = "活动名称")
    private String name;

    @ApiModelProperty(value = "关联地址")
    private String relUrl;

    @ApiModelProperty(value = "图片地址")
    private String pictureUrl;

    @ApiModelProperty(value = "是否启用 true 启用 false 不启用")
    @TableField(value = "`use`")
    private Boolean use;

    @ApiModelProperty(value = "是否显示名称 true 显示 false 不显示")
    private Boolean showName;

}
