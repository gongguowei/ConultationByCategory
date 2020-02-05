package com.aircos.service.impl;

import com.aircos.entity.vo.CategoryAllVo;
import com.aircos.entity.vo.CategoryVo;
import com.aircos.mapper.CategoryMapper;
import com.aircos.service.CategoryService;
import com.aircos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service of 专业品类
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final UserService userService;

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper, UserService userService) {
        this.categoryMapper = categoryMapper;
        this.userService = userService;
    }

    @Override
    public List<CategoryVo> listOne() {
        return categoryMapper.queryCategoryOne();
    }

    @Override
    public List<CategoryVo> listTree(int pid, int level) {
        return categoryMapper.queryCategoryTree(pid, level);
    }

    @Override
    public List<CategoryAllVo> list() {
        return categoryMapper.queryCategoryAllTree();
    }

}
