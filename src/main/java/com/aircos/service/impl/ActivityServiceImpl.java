package com.aircos.service.impl;

import com.aircos.entity.dao.Activity;
import com.aircos.entity.dao.User;
import com.aircos.entity.dto.CreateActivityDto;
import com.aircos.entity.vo.ActivityVo;
import com.aircos.mapper.ActivityMapper;
import com.aircos.service.ActivityService;
import com.aircos.service.UserService;
import com.aircos.util.SecurityUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service of 首页活动轮播图
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    private final UserService userService;

    private final ActivityMapper activityMapper;

    @Autowired
    public ActivityServiceImpl(ActivityMapper activityMapper, UserService userService) {
        this.activityMapper = activityMapper;
        this.userService = userService;
    }

    @Override
    public List<ActivityVo> list(Integer pageIndex, Integer pageSize) {
        IPage<ActivityVo> page = new Page<>(pageIndex, pageSize);
        return activityMapper.activityList(page);
    }

    @Override
    public void create(CreateActivityDto body) {
        User loginUser = userService.findByPhone(SecurityUtils.getPhone());
        List<Activity> allActivities = activityMapper.selectList(null);

        checkSeq(allActivities, body.getSeq());
        //装载
        Activity record = new Activity();

        record.setSeq(body.getSeq());
        record.setUse(body.getUse());
        record.setName(body.getName());
        record.setRelUrl(body.getRelUrl());
        record.setShowName(body.getShowName());
        record.setCreateId(loginUser.getId());
        record.setPictureUrl(body.getPictureUrl());
        activityMapper.insert(record);
    }

    @Override
    public void update(Activity body) {
        User loginUser = userService.findByPhone(SecurityUtils.getPhone());
        List<Activity> allActivities = activityMapper.selectList(null);

        checkSeq(allActivities, body.getSeq());

        body.setCreateId(loginUser.getId());
        activityMapper.updateById(body);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void delete(int id) {
        //TODO 分布式请注意一致性问题, 这里只做简单的判断
        Activity check = activityMapper.selectById(id);
        if (null == check) {
            throw new ServiceException("该轮播图已被删除!");
        }
        activityMapper.deleteById(id);
    }

    @Override
    public IPage<Activity> listAdminActivity(Integer pageIndex, Integer pageSize) {
        IPage<Activity> page = new Page(pageIndex, pageSize);
        return activityMapper.selectPage(page, null);
    }

    /**
     * 首页轮播图排序校验
     *
     * @param allActivities 轮播图列表
     * @param seq 需要检验的排序
     */
    private void checkSeq(List<Activity> allActivities, Integer seq) {
        List<Activity> check = allActivities
                .stream()
                .filter(activity ->
                        activity.getSeq().equals(seq))
                .collect(Collectors.toList());
        if (0 != check.size()) {
            throw new ServiceException("排序已存在!");
        }
    }
}
