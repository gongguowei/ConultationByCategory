package com.aircos.entity.dto;

import com.aircos.entity.dao.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 创建院校信息
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-04
 */
@ApiModel
@Data
public class CreateSchoolDto {

    @ApiModelProperty(value = "学校基本信息")
    private School school;

    @ApiModelProperty(value = "就业前景概况")
    private TrendSurvey trendSurvey;

    @ApiModelProperty(value = "行业去向")
    private List<TrendWork> trendWorkList;

    @ApiModelProperty(value = "地区去向")
    private List<TrendArea> trendAreaList;

    @ApiModelProperty(value = "招生简章")
    private List<SchoolEssay> schoolEssayList;

    @ApiModelProperty(value = "学校专业计划招生人数")
    private List<RelationSchoolProfession> relationSchoolProfessionList;

}
