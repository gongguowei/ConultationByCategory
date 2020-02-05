package com.aircos.controller.admin;

import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.dto.CreateCategoryDto;
import com.aircos.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of 管理员端：品类接口
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Slf4j
@Api(tags = "AdminCategoryController", description = "管理员端：品类接口")
@RestController
@RequestMapping("/v1/admin/category")
public class AdminCategoryController {

    private final CategoryService categoryService;

    @Autowired
    public AdminCategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }


}
