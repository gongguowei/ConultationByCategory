package com.aircos.service.impl;

import com.aircos.entity.dao.Headline;
import com.aircos.entity.dao.User;
import com.aircos.entity.dto.QueryHeadlineDto;
import com.aircos.entity.vo.HeadlineVo;
import com.aircos.mapper.HeadlineMapper;
import com.aircos.service.HeadlineService;
import com.aircos.service.UserService;
import com.aircos.util.SecurityUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service of 首页招生头条
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Service
public class HeadlineServiceImpl implements HeadlineService {

    private final UserService userService;

    private final HeadlineMapper headlineMapper;

    @Autowired
    public HeadlineServiceImpl(HeadlineMapper headlineMapper, UserService userService) {
        this.headlineMapper = headlineMapper;
        this.userService = userService;
    }


    @Override
    public IPage<HeadlineVo> list(Integer pageIndex, Integer pageSize) {
        IPage<HeadlineVo> page = new Page(pageIndex, pageSize);
        return headlineMapper.queryHeadlinesByPage(page);
    }

    @Override
    public Headline detail(QueryHeadlineDto query) {
        return headlineMapper.selectById(query.getId());
    }

    @Override
    public void create(Headline body) {
        User loginUser = userService.findByPhone(SecurityUtils.getPhone());
        body.setCreateUid(loginUser.getId());
        headlineMapper.insert(body);
    }

    @Override
    public void update(Headline before) {
        User loginUser = userService.findByPhone(SecurityUtils.getPhone());
        Headline after = headlineMapper.selectById(before.getId());

        after.setBody(before.getBody());
        after.setTitle(before.getTitle());
        after.setCategory(before.getCategory());
        after.setPictureUrl(before.getPictureUrl());
        after.setCreateUid(loginUser.getId());

        headlineMapper.updateById(after);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(int id) {
        //TODO 可以先查询被删除数据是否存在
        headlineMapper.deleteById(id);
    }

    @Override
    public IPage<Headline> listAdminHeadline(Integer pageIndex, Integer pageSize, QueryHeadlineDto queryHeadline) {
        IPage page = new Page(pageIndex, pageSize);
        return headlineMapper.selectPage(page, new QueryWrapper<Headline>()
                .lambda()
                .eq(null != queryHeadline.getId(), Headline::getId, queryHeadline.getId()));
    }
}
