package com.aircos.controller;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.vo.CategoryAllVo;
import com.aircos.entity.vo.CategoryVo;
import com.aircos.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller of 专业品类
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Slf4j
@Api(tags = "CategoryController", description = "专业品类接口")
@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(
            value = "用户端: 获取一层品类列表",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/list/one")
    public Result<List<CategoryVo>> listOne() {
        //TODO 与 Get:/v1/list/tree 可以合并为一个接口
        List<CategoryVo> result = categoryService.listOne();
        return ResultGenerator.success(result);
    }

    @ApiOperation(
            value = "用户端: 获取指定层品类列表",
            authorizations = { @Authorization(value = "jwt")},
            notes = "level范围：[1,2,3]"
    )
    @GetMapping("/list/tree")
    public Result<List<CategoryVo>> listTree(int pid, int level) {
        List<CategoryVo> result = categoryService.listTree(pid, level);
        return ResultGenerator.success(result);
    }

    @ApiOperation(
            value = "用户端: 3层品类列表",
            authorizations = {@Authorization(value = "jwt")}
    )
    @GetMapping("/list")
    public Result<List<CategoryAllVo>> list() {
        return ResultGenerator.success(categoryService.list());
    }
}
