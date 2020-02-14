package com.aircos.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 问题查询条件
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-09
 */
@ApiModel
@Data
public class QueryQuestionDto {

    @ApiModelProperty(value = "1:性格 2:兴趣")
    private Integer questionType;

}
