package com.aircos.mapper;

import com.aircos.entity.bo.SchoolBO;
import com.aircos.entity.dao.School;
import com.aircos.entity.vo.SchoolAreaVo;
import com.aircos.entity.vo.SchoolProfessionVo;
import com.aircos.entity.vo.SchoolVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper of 院校
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
@Repository
public interface SchoolMapper extends BaseMapper<School> {

    /**
     * 通过 答案 + 总分 查询匹配的院校
     *
     * @param page 分页信息
     * @param answer 答案
     * @return 满足条件的院校，根据匹配指数从高到低排序
     */
    IPage<SchoolBO> selectListByAnswer(IPage page,
                                       @Param("answer") String answer);

    /**
     * 配合Xml，根据专业ID查询匹配的院校
     *
     * @param professionId 专业ID
     * @return 院校列表
     */
    List<School> querySchoolsByProfessionId(@Param("profession_id") String professionId);

    /**
     * 根据学校ID查询匹配的专业
     *
     * @param schoolId 学校ID
     * @return 学校ID + 专业
     */
    SchoolProfessionVo queryProfessionsBySchoolId(int schoolId);

    /**
     * 查询已有学校所有的市地址
     *
     * @return 地址列表
     */
    @Select("SELECT address_city FROM aircos_school GROUP BY address_city")
    List<SchoolAreaVo> queryCategory();

    /**
     * 根据条件查询学校列表
     *
     * @param page 分页信息
     * @param queryWrapper 查询条件
     * @return
     */
    @Select("SELECT id, school_name, address AS schoolAddress, picture_logo AS schoolLogo FROM aircos_school ${ew.customSqlSegment}")
    IPage<SchoolVo> listSchoolByCondition(IPage page, @Param(Constants.WRAPPER) Wrapper<School> queryWrapper);
}
