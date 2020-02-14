package com.aircos.service.impl;

import com.aircos.core.ServiceException;
import com.aircos.entity.bo.ProfessionBO;
import com.aircos.entity.bo.SchoolBO;
import com.aircos.entity.dao.User;
import com.aircos.entity.dto.CreateEvaluationDto;
import com.aircos.entity.vo.evaluation.EvaluationVo;
import com.aircos.entity.vo.evaluation.QuestionVo;
import com.aircos.mapper.EvaluationMapper;
import com.aircos.mapper.ProfessionMapper;
import com.aircos.mapper.QuestionMapper;
import com.aircos.mapper.SchoolMapper;
import com.aircos.service.EvaluationService;
import com.aircos.service.UserService;
import com.aircos.util.SecurityUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private final QuestionMapper questionMapper;

    private final ProfessionMapper professionMapper;

    @Autowired
    public EvaluationServiceImpl(EvaluationMapper evaluationMapper, UserService userService, SchoolMapper schoolMapper,
                                 ProfessionMapper professionMapper, QuestionMapper questionMapper) {
        this.userService = userService;
        this.schoolMapper = schoolMapper;
        this.professionMapper = professionMapper;
        this.questionMapper = questionMapper;
    }

    @Override
    public EvaluationVo createEvaluation(CreateEvaluationDto body) {
        EvaluationVo result = new EvaluationVo();
        //loginUser必须作为局部变量, 防止线程安全问题
        User loginUser = userService.findByPhone(SecurityUtils.getPhone());

        //根据当前登录用户的分数获取可以报考的院校
        int failSubject = 3;
        if (computeTotalSource(loginUser) >= failSubject) {
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
        IPage<SchoolBO> schoolListByAnswer = schoolMapper.selectListByAnswer(schoolBOPage, stringBuffer.toString());

        //根据答案推荐对应的专业
        IPage<ProfessionBO> professionListByAnswer = professionMapper.selectByAnswer(professionBOPage, stringBuffer.toString());

        //TODO 与公司合作的学校，有推荐给用户的专业，优先推荐该学校

        //装载
        result.setSuitableSchool(schoolListByAnswer);
        result.setSuitableProfession(professionListByAnswer);
        return result;
    }

    @Override
    public List<QuestionVo> listQuestion(int questionType) {
        return questionMapper.listQuestions(questionType);
    }

    /**
     * 检查当前登录用户的会考成绩
     * Note: 会考成绩三门为D的同学无法安排学校
     *
     * @param loginUser 当前登录用户
     * @return 不及格成绩
     */
    protected int computeTotalSource(User loginUser) {
        List<String> ready = new ArrayList<>(12);

        ready.add(loginUser.getSourceMathematics());
        ready.add(loginUser.getSourceChinese());
        ready.add(loginUser.getGeneralTechnology());
        ready.add(loginUser.getSourceBiology());
        ready.add(loginUser.getSourceChemistry());
        ready.add(loginUser.getSourceGeography());
        ready.add(loginUser.getSourcePolitics());
        ready.add(loginUser.getSourceEnglish());
        ready.add(loginUser.getSourceHistory());
        ready.add(loginUser.getSourceInformation());
        ready.add(loginUser.getSourcePhysics());

        int subjectCheck = 11;
        if (subjectCheck != ready.size()) {
            throw new ServiceException("请完善会考成绩！我的 -> 输入成绩");
        }

        return ready.stream().filter(source -> "D".equals(source)).collect(Collectors.toList()).size();
    }
}
