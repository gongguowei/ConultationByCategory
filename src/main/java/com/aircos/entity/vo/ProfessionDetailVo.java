package com.aircos.entity.vo;

import com.aircos.entity.dao.Profession;
import com.aircos.entity.dao.School;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 返回给前端的专业详细信息
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@ApiModel
@Data
public class ProfessionDetailVo extends Profession {

    @ApiModelProperty(value = "专业特殊要求")
    private String need;

    @ApiModelProperty(value = "开设院校")
    private List<School> schoolList;
}
