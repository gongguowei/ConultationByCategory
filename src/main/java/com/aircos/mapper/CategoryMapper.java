package com.aircos.mapper;

import com.aircos.entity.dao.Category;
import com.aircos.entity.vo.CategoryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper of 专业品类
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询指定层级品类
     *
     * @param pid 顶级父ID
     * @param level 层级
     * @return 二级品类列表
     */
    List<CategoryVo> queryCategoryTree(@Param("pid") int pid,
                                       @Param("level") int level);

    /**
     * 获取所有一级品类
     *
     * @return 一级品类列表
     */
    List<CategoryVo> queryCategoryOne();

}
