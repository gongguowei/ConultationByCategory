package com.aircos.entity.vo;

import com.aircos.entity.bo.ProfessionBO;
import com.aircos.entity.dao.Profession;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 返回给前端的学校专业列表
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-03
 */
@ApiModel
@Data
public class SchoolProfessionVo {
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "专业列表")
    private List<ProfessionBO> professions;
}
