package com.aircos.service.impl;

import com.aircos.core.ServiceException;
import com.aircos.entity.bo.ProfessionBO;
import com.aircos.entity.bo.SchoolBO;
import com.aircos.entity.dao.School;
import com.aircos.entity.dao.User;
import com.aircos.entity.dto.CreateEvaluationDto;
import com.aircos.entity.vo.evaluation.EvaluationVo;
import com.aircos.mapper.EvaluationMapper;
import com.aircos.mapper.ProfessionMapper;
import com.aircos.mapper.SchoolMapper;
import com.aircos.service.EvaluationService;
import com.aircos.service.UserService;
import com.aircos.util.SecurityUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service of 专业倾向测评
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-27
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {

    private final UserService userService;

    private final SchoolMapper schoolMapper;

    private final ProfessionMapper professionMapper;

    @Autowired
    public EvaluationServiceImpl(EvaluationMapper evaluationMapper, UserService userService, SchoolMapper schoolMapper,
                                 ProfessionMapper professionMapper) {
        this.userService = userService;
        this.schoolMapper = schoolMapper;
        this.professionMapper = professionMapper;
    }

    @Override
    public EvaluationVo createEvaluation(CreateEvaluationDto body) {
        EvaluationVo result = new EvaluationVo();
        //loginUser必须作为局部变量, 防止线程安全问题
        User loginUser = userService.findByPhone(SecurityUtils.getPhone());

        //根据当前登录用户的分数获取可以报考的院校
        Integer totalSource = computeTotalSource(loginUser);
        List<School> schoolList = schoolMapper.selectList(new QueryWrapper<School>()
                .lambda()
                .le(School::getSourceMin, totalSource));
        if (0 == schoolList.size()) {
            throw new ServiceException("暂没有满足的院校");
        }
        //TODO 答案与院校的关系可以考虑使用 Redis 缓存
        //根据答案推荐报考的院校, 权重：院校 > 专业
        StringBuffer stringBuffer = new StringBuffer();
        Page<SchoolBO> schoolBOPage = new Page<>(body.getPageIndex(), body.getPageSize());
        Page<ProfessionBO> professionBOPage = new Page<>(body.getPageIndex(), body.getPageSize());
        body.getAnswerList().forEach(one -> {
            stringBuffer.append(one);
        });
        IPage<SchoolBO> schoolListByAnswer = schoolMapper.selectListByAnswer(schoolBOPage, stringBuffer.toString(), totalSource);

        //根据答案推荐对应的专业
        IPage<ProfessionBO> professionListByAnswer = professionMapper.selectByAnswer(professionBOPage, stringBuffer.toString());

        //装载
        result.setSuitableSchool(schoolListByAnswer);
        result.setSuitableProfession(professionListByAnswer);
        return result;
    }

    protected Integer computeTotalSource(User loginUser) {
        return loginUser.getSourceChinese() + loginUser.getSourceMathematics();
    }
}
