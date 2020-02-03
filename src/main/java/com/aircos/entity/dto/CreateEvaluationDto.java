package com.aircos.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 创建专业倾向测评
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
@ApiModel
@Data
public class CreateEvaluationDto {

    @Min(value = 1)
    @ApiModelProperty(value = "页码", required = true)
    private Integer pageIndex;

    @Min(value = 1)
    @ApiModelProperty(value = "页数", required = true)
    private Integer pageSize;

    @NotEmpty
    @ApiModelProperty(value = "答案", required = true)
    private List<String> answerList;
}
