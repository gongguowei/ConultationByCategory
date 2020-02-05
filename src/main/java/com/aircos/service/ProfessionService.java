package com.aircos.service;

import com.aircos.entity.dao.Profession;
import com.aircos.entity.dto.CreateProfessionDto;
import com.aircos.entity.vo.ProfessionDetailVo;
import com.aircos.entity.vo.QueryProfessionVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * Interface of 专业
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
public interface ProfessionService extends IService<Profession> {

    /**
     * 用户端：获取专业详情
     *
     * @param professionId 主键
     * @return 专业详情
     */
    ProfessionDetailVo list(int professionId);

    /**
     * 用户端：根据关键字获取专业
     *
     * @param keyWord 关键字
     * @param pageIndex 页码
     * @param pageSize 页数
     * @return 专业列表
     */
    IPage<QueryProfessionVo> query(String keyWord, Integer pageIndex, Integer pageSize);

    /**
     * 管理员端：创建专业信息
     *
     * @param body 专业信息
     */
    void create(CreateProfessionDto body);

    /**
     * 管理员端：更新专业信息
     *
     * @param body 专业信息
     */
    void update(CreateProfessionDto body);

    /**
     * 管理员端：删除专业信息
     *
     * @param professionId 主键
     * @param level 被删除Id的层级
     */
    void delete(int professionId, int level);
}
