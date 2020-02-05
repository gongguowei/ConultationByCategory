package com.aircos.mapper;

import com.aircos.core.mybatis.base.MyBaseMapper;
import com.aircos.entity.bo.ProfessionBO;
import com.aircos.entity.dao.Profession;
import com.aircos.entity.vo.ProfessionDetailVo;
import com.aircos.entity.vo.QueryProfessionVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper of 专业
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
@Repository
public interface ProfessionMapper extends MyBaseMapper<Profession> {

    /**
     * 根据答案获取用户适合的专业
     *
     * @param page 分页信息
     * @param answer 答案
     * @return 专业列表，根据匹配指数从高到低排序
     */
    IPage<ProfessionBO> selectByAnswer(Page<ProfessionBO> page,
                                       @Param("answer") String answer);

    /**
     * 根据主键查询专业信息
     *
     * @param professionId 主页
     * @return 专业基本信息 + 专业开设院校
     */
    ProfessionDetailVo queryProfessionDetail(@Param("professionId") int professionId);

    /**
     * 通过关键字查询专业
     *
     * @param page 分页信息
     * @param keyWord 关键字
     * @return 专业列表
     */
    IPage<QueryProfessionVo> queryProfessionsByKeyWord(IPage page,
                                                       @Param("keyWord") String keyWord);

    /**
     * 通过学校ID查询专业列表
     *
     * @param schoolId 学校ID
     * @return 专业列表
     */
    List<ProfessionBO> queryProfessionBySchoolId(@Param("schoolId") Integer schoolId);

}
