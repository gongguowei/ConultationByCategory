package com.aircos.service;

import com.aircos.entity.dto.CreateCategoryDto;
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
     * Admin of 专业品类创建
     *
     * @param body 品类信息
     */
    void create(CreateCategoryDto body);

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
     * Admin of 专业品类更新
     *
     * @param body 更新的品类信息
     */
    void update(CreateCategoryDto body);

    /**
     * Admin of 删除品类
     *
     * @param id 品类表主键
     */
    void delete(int id);
}
