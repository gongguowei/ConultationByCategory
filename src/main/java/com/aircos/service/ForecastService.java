package com.aircos.service;

import com.aircos.entity.dao.Question;
import com.aircos.entity.dao.WaitingOption;
import com.aircos.entity.dto.QueryQuestionDto;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * Interface of 管理员端：预测模块问题答案设置
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-09
 */
public interface ForecastService {

    /**
     * 管理员端：批量创建问题
     *
     * @param body 问题内容
     */
    void createQuestion(List<Question> body);

    /**
     * 管理员端：获取问题列表
     *
     * @param pageIndex 页码
     * @param pageSize 页数
     * @param query 查询条件
     * @return 问题列表
     */
    IPage<Question> list(Integer pageIndex, Integer pageSize, QueryQuestionDto query);

    /**
     * 管理员端：创建问题待选项答案
     *
     * @param body 问题待选项答案
     */
    void createWait(List<WaitingOption> body);

    /**
     * 管理员端：获取问题待选项答案
     *
     * @param questionId 问题ID
     * @return 问题待选项
     */
    List<WaitingOption> listWait(Integer questionId);


    /**
     * 管理员端：删除问题
     *
     * @param id 问题ID
     */
    void deleteQuestion(int id);

    /**
     * 管理员端：删除问题回答待选项
     *
     * @param id 问题回答待选项ID
     */
    void deleteWait(int id);

    /**
     * 管理员端：更新问题
     *
     * @param body 更新后的问题
     */
    void updateQuestion(Question body);

    /**
     * 管理员端：更新问题待选项
     *
     * @param body 更新后的问题待选项
     */
    void updateWait(WaitingOption body);
}
