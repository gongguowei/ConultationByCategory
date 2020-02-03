package com.aircos.service.impl;

import com.aircos.core.ServiceException;
import com.aircos.entity.dao.Category;
import com.aircos.entity.dao.User;
import com.aircos.entity.dto.CreateCategoryDto;
import com.aircos.entity.vo.CategoryVo;
import com.aircos.mapper.CategoryMapper;
import com.aircos.service.CategoryService;
import com.aircos.service.UserService;
import com.aircos.util.SecurityUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public void create(CreateCategoryDto body) {
        User loginUser = userService.findByPhone(SecurityUtils.getPhone());
        Category record = new Category();

        setValues(record, body);

        record.setCreateUid(loginUser.getId());
        categoryMapper.insert(record);
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
    public void update(CreateCategoryDto body) {
        Category category = new Category();
        if(existsById(body)){
            throw new ServiceException("没有找到相应的品类id");
        }
        category.setId(body.getId());
        setValues(category, body);
        categoryMapper.updateById(category);
    }

    @Override
    public void delete(int id) {
        Category before = categoryMapper.selectById(id);

        if (null == before) {
            throw new ServiceException("id :" + id + "不存在");
        }
        before.setIsDeleted(false);
        categoryMapper.updateById(before);
    }


    /**
     * 校验且设置品类的父级ID
     *
     * @param category 准备插入的品类
     * @param categoryDto 品类数据准备
     */
    private void setValues(Category category , CreateCategoryDto categoryDto){
        Integer pid = categoryDto.getPid();

        category.setCategoryName(categoryDto.getCategoryName());
        category.setLevel(categoryDto.getLevel());

        //判断是否为顶级路径
        if(!categoryDto.getLevel().equals(1) && null != pid) {
            if (!existsById(categoryDto)) {
                category.setPid(pid);
            } else {
                throw new ServiceException("无法匹配父级类型");
            }
        }
    }

    private Boolean existsById(CreateCategoryDto categoryDto) {
        Integer existsById = categoryMapper.selectCount(new QueryWrapper<Category>()
                .lambda()
                .eq(Category::getId, categoryDto.getPid()));
        if (0 != existsById) {
            return false;
        } else {
            return true;
        }
    }
}
