package com.aircos.controller;

import com.aircos.aop.QueryProfessionLogPoint;
import com.aircos.core.Result;
import com.aircos.core.ResultGenerator;
import com.aircos.entity.vo.ProfessionDetailVo;
import com.aircos.entity.vo.QueryProfessionVo;
import com.aircos.service.ProfessionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller of 用户端：专业大全
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Slf4j
@Api(tags = "ProfessionController", description = "用户端：专业大全")
@RestController
@RequestMapping("/v1/profession")
public class ProfessionController {

    private final ProfessionService professionService;

    @Autowired
    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @ApiOperation(
            value = "用户端：获取专业信息详情",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/list")
    public Result<ProfessionDetailVo> list(int professionId) {
        ProfessionDetailVo result = professionService.list(professionId);
        return ResultGenerator.success(result);
    }

    @ApiOperation(
            value = "用户端：搜索专业",
            authorizations = { @Authorization(value = "jwt")}
    )
    @GetMapping("/query")
    @QueryProfessionLogPoint("搜索专业信息")
    public Result<IPage<QueryProfessionVo>> query(
            @RequestParam(required = false) String keyWord,
            @RequestParam(required = false, defaultValue = "1")Integer pageIndex,
            @RequestParam(required = false, defaultValue = "5")Integer pageSize
    ) {
        //TODO 接收参数三个以上可以考虑使用实例接收
        IPage<QueryProfessionVo> result = professionService.query(keyWord, pageIndex, pageSize);
        return ResultGenerator.success(result);
    }
}
