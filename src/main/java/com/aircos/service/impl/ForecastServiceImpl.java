package com.aircos.service.impl;

import com.aircos.core.ServiceException;
import com.aircos.entity.dao.Question;
import com.aircos.entity.dao.WaitingOption;
import com.aircos.entity.dto.QueryQuestionDto;
import com.aircos.mapper.QuestionMapper;
import com.aircos.mapper.WaitingOptionMapper;
import com.aircos.service.ForecastService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service of 管理员端：预测模块问题答案设置
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-09
 */
@Service
public class ForecastServiceImpl implements ForecastService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private WaitingOptionMapper waitingOptionMapper;

    @Override
    public void createQuestion(List<Question> body) {
        if (0 == body.size()) {
            throw new ServiceException("至少创建一个问题啊。");
        }
        questionMapper.insertBatchSomeColumn(body);
    }

    @Override
    public IPage<Question> list(Integer pageIndex, Integer pageSize, QueryQuestionDto query) {
        IPage<Question> page = new Page(pageIndex, pageSize);
        return questionMapper.selectPage(page, new QueryWrapper<Question>()
                .lambda()
                .eq(null != query.getQuestionType(), Question::getQuestionType, query.getQuestionType()));
    }

    @Override
    public void createWait(List<WaitingOption> body) {
        if (0 == body.size()) {
            throw new ServiceException("至少创建一个问题答案待选项啊。");
        }
        waitingOptionMapper.insertBatchSomeColumn(body);
    }

    @Override
    public List<WaitingOption> listWait(Integer questionId) {
        List<WaitingOption> result = waitingOptionMapper.selectList(new QueryWrapper<WaitingOption>()
                        .lambda()
                        .eq(WaitingOption::getQuestionId, questionId));
        if (0 == result.size()) {
            return new ArrayList<>(0);
        }
        return result;
    }

    @Override
    public void deleteQuestion(int id) {
        Question question = questionMapper.selectById(id);
        if (null == question) {
            throw new ServiceException("问题咋不存了？你刷新页面看看它还在不。");
        }
        questionMapper.deleteById(id);
        //获取问题下的问题待选项
        List<WaitingOption> waitingOptions = waitingOptionMapper.selectList(new QueryWrapper<WaitingOption>()
                .lambda()
                .eq(WaitingOption::getQuestionId, id));
        if (0 != waitingOptions.size()) {
            List<Integer> waitIds = waitingOptions.stream()
                    .map(WaitingOption::getId)
                    .collect(Collectors.toList());

            waitingOptionMapper.deleteBatchIds(waitIds);
        }
    }

    @Override
    public void deleteWait(int id) {
        WaitingOption waitingOption = waitingOptionMapper.selectById(id);
        if (null == waitingOption) {
            throw new ServiceException("这个问题待选答案咋不在了？你刷新页面看看它还在不。");
        }
        Question question = questionMapper.selectById(waitingOption.getQuestionId());

        if (null == question) {
            throw new ServiceException("问题咋不存了？你刷新页面看看它还在不。");
        }
        waitingOptionMapper.deleteById(id);
    }

    @Override
    public void updateQuestion(Question after) {
        Question before = questionMapper.selectById(after.getId());
        if (null == before) {
            throw new ServiceException("问题都不在了，更新不了！你刷新页面看看它还在不。");
        }
        before.setQuestion(after.getQuestion());
        before.setQuestionType(after.getQuestionType());
        questionMapper.updateById(before);
    }

    @Override
    public void updateWait(WaitingOption after) {
        WaitingOption before = waitingOptionMapper.selectById(after.getId());
        if (null == before) {
            throw new ServiceException("问题待选项答案都不在了，更新不了！你刷新页面看看它还在不。");
        }
        before.setDetail(after.getOptions());
        before.setOptions(after.getOptions());
        before.setQuestionId(after.getQuestionId());
        waitingOptionMapper.updateById(before);
    }
}
