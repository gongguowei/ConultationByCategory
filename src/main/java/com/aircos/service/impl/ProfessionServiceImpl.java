package com.aircos.service.impl;

import com.aircos.entity.vo.ProfessionDetailVo;
import com.aircos.entity.vo.QueryProfessionVo;
import com.aircos.mapper.ProfessionMapper;
import com.aircos.service.ProfessionService;
import com.aircos.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service of 专业
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Service
public class ProfessionServiceImpl implements ProfessionService {

    private final UserService userService;

    private final ProfessionMapper professionMapper;

    @Autowired
    public ProfessionServiceImpl(ProfessionMapper professionMapper, UserService userService) {
        this.professionMapper = professionMapper;
        this.userService = userService;
    }

    @Override
    public ProfessionDetailVo list(int professionId) {

        return professionMapper.queryProfessionDetail(professionId);
    }

    @Override
    public IPage<QueryProfessionVo> query(String keyWord, Integer pageIndex, Integer pageSize) {
        IPage page = new Page(pageIndex, pageSize);
        return professionMapper.queryProfessionsByKeyWord(page, keyWord);
    }
}
