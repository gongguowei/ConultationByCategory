package com.aircos.service;

import com.aircos.entity.dto.CreateCategoryDto;
import com.aircos.entity.vo.CategoryAllVo;
import com.aircos.entity.vo.CategoryVo;

import java.util.List;

/**
 * Interface of 专业品类
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
public interface CategoryService {

    /**
     * 获取1层品类列表
     *
     * @return 所有1层品类
     */
    List<CategoryVo> listOne();

    /**
     * 获取指定层品类列表
     *
     * @param pid 顶级父ID
     * @param level 层级
     * @return
     */
    List<CategoryVo> listTree(int pid, int level);

    /**
     * 返回所有品类
     *
     * @return 品类列表
     */
    List<CategoryAllVo> list();
}

