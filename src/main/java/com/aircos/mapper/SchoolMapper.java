package com.aircos.mapper;

import com.aircos.entity.bo.SchoolBO;
import com.aircos.entity.dao.School;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
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
     * @param totalSource 总分数
     * @return 满足条件的院校，根据匹配指数从高到低排序
     */
    IPage<SchoolBO> selectListByAnswer(IPage page,
                                       @Param("answer") String answer,
                                       @Param("totalSource") Integer totalSource);

    /**
     * 配合Xml，根据专业ID查询匹配的院校
     *
     * @param professionId 专业ID
     * @return 院校列表
     */
    List<School> querySchoolsByProfessionId(@Param("profession_id") String professionId);
}
