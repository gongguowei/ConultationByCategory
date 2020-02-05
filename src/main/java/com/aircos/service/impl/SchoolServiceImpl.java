package com.aircos.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.aircos.entity.dao.*;
import com.aircos.entity.dto.CreateSchoolDto;
import com.aircos.entity.dto.QuerySchoolDto;
import com.aircos.entity.vo.SchoolAreaVo;
import com.aircos.entity.vo.SchoolProfessionVo;
import com.aircos.entity.vo.SchoolVo;
import com.aircos.mapper.*;
import com.aircos.service.SchoolService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service of 学校
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-03
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private SchoolMapper schoolMapper;

    @Resource
    private TrendAreaMapper trendAreaMapper;

    @Resource
    private TrendWorkMapper trendWorkMapper;

    @Resource
    private SchoolEssayMapper schoolEssayMapper;

    @Resource
    private TrendSurveyMapper trendSurveyMapper;

    @Resource
    private RelationSchoolProfessionMapper relationSchoolProfessionMapper;

    @Override
    public SchoolProfessionVo query(int schoolId) {
        return schoolMapper.queryProfessionsBySchoolId(schoolId);
    }

    @Override
    public void create(CreateSchoolDto body) {
        School recordSchool = new School();
        TrendSurvey recordSurvey = new TrendSurvey();

        CopyOptions copyOptions = CopyOptions.create().ignoreNullValue();

        //创建学校基本信息
        BeanUtil.copyProperties(body.getSchool(), recordSchool, copyOptions);
        StringBuffer sb = new StringBuffer();
        School school = body.getSchool();
        //省 + 市 + 区 + 详细地址
        String address = sb.append(school.getAddressProvince())
                .append(school.getAddressCity())
                .append(school.getAddressRegion())
                .append(school.getAddressOther()).toString();
        recordSchool.setAddress(address);
        schoolMapper.insert(recordSchool);

        //创建毕业走向
        BeanUtil.copyProperties(body.getTrendSurvey(), recordSurvey, copyOptions);
        recordSurvey.setSchoolId(recordSchool.getId());
        trendSurveyMapper.insert(recordSurvey);

        List<TrendArea> trendAreaList = body.getTrendAreaList();
        trendAreaList.forEach(trendArea -> {
            trendArea.setSchoolId(recordSchool.getId());
        });
        trendAreaMapper.insertBatchSomeColumn(trendAreaList);

        List<TrendWork> trendWorkList = body.getTrendWorkList();
        trendWorkList.forEach(trendWork -> {
            trendWork.setSchoolId(recordSchool.getId());
        });
        trendWorkMapper.insertBatchSomeColumn(trendWorkList);

        //创建招生简章
        List<SchoolEssay> schoolEssayList = body.getSchoolEssayList();
        schoolEssayList.forEach(schoolEssay -> {
            schoolEssay.setSchoolId(recordSchool.getId());
        });
        schoolEssayMapper.insertBatchSomeColumn(schoolEssayList);

        //创建学校与专业关系
        List<RelationSchoolProfession> relationSchoolProfessionList = body.getRelationSchoolProfessionList();
        relationSchoolProfessionList.forEach(relationSchoolProfession -> {
            relationSchoolProfession.setSchoolId(recordSchool.getId());
        });
        relationSchoolProfessionMapper.insertBatchSomeColumn(relationSchoolProfessionList);
    }

    @Override
    public IPage<School> listAdminSchool(Integer pageIndex, Integer pageSize, QuerySchoolDto querySchool) {
        IPage page = new Page(pageIndex, pageSize);
        return schoolMapper.selectPage(page, new QueryWrapper<School>()
                .lambda()
                .like(null != querySchool.getSchoolName(), School::getSchoolName, querySchool.getSchoolName())
                .like(null != querySchool.getSchoolAddress(), School::getAddress, querySchool.getSchoolAddress()));
    }

    @Override
    public List<SchoolAreaVo> queryCategory() {
        return schoolMapper.queryCategory();
    }

    @Override
    public IPage<SchoolVo> listUserSchool(Integer pageIndex, Integer pageSize, QuerySchoolDto querySchool) {
        IPage page = new Page(pageIndex, pageSize);
        return schoolMapper.listSchoolByCondition(page, new QueryWrapper<School>()
                .lambda()
                .like(null != querySchool.getSchoolName(), School::getSchoolName, querySchool.getSchoolName())
                .like(null != querySchool.getSchoolAddress(), School::getAddress, querySchool.getSchoolAddress()));
    }
}

