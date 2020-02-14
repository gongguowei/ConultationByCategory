package com.aircos.entity.vo.evaluation;

import com.aircos.entity.dao.WaitingOption;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 返回给前端的问题列表
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-09
 */
@ApiModel
@Data
public class QuestionVo {
    @ApiModelProperty(value = "问题ID")
    private Integer id;

    @ApiModelProperty(value = "问题")
    private String question;

    @ApiModelProperty(value = "问题候选项")
    private List<WaitingOption> waitingOptions;
}
