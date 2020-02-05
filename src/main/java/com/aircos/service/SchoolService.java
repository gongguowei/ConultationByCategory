package com.aircos.service;

import com.aircos.entity.dao.School;
import com.aircos.entity.dto.CreateSchoolDto;
import com.aircos.entity.dto.QuerySchoolDto;
import com.aircos.entity.vo.SchoolAreaVo;
import com.aircos.entity.vo.SchoolProfessionVo;
import com.aircos.entity.vo.SchoolVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * Interface of 学校
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-03
 */
public interface SchoolService {

    /**
     * 查询指定学校下的专业
     *
     * @param schoolId 主键
     * @return 学校专业信息
     */
    SchoolProfessionVo query(int schoolId);

    /**
     * 管理员端：创建学校
     *
     * @param body 学校信息
     */
    void create(CreateSchoolDto body);

    /**
     * 管理员端：根据条件查询学校
     *
     * @param pageIndex 页码
     * @param pageSize 页数
     * @param querySchool 查询条件
     *
     * @return 学校列表
     */
    IPage<School> listAdminSchool(Integer pageIndex, Integer pageSize, QuerySchoolDto querySchool);

    /**
     * 用户端：根据地区获取所有学校
     *
     * @return 地址（市）列表
     */
    List<SchoolAreaVo> queryCategory();

    /**
     * 用户端：根据查询条件获取校园
     *
     * @param pageIndex 页码
     * @param pageSize 页数
     * @param querySchool 查询条件
     * @return 爱校园模块 - 校园列表
     */
    IPage<SchoolVo> listUserSchool(Integer pageIndex, Integer pageSize, QuerySchoolDto querySchool);
}
