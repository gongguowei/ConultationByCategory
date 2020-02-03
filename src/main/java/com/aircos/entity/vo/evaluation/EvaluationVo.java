package com.aircos.entity.vo.evaluation;

import com.aircos.entity.bo.ProfessionBO;
import com.aircos.entity.bo.SchoolBO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回给前端的用户倾向测评对象
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
@ApiModel
@Data
public class EvaluationVo {

    @ApiModelProperty(value = "适合的学校")
    IPage<SchoolBO> suitableSchool;

    @ApiModelProperty(value = "适合的专业")
    IPage<ProfessionBO> suitableProfession;

}
