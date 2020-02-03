package com.aircos.entity.bo;

import lombok.Data;

/**
 * biz object of 专业
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
@Data
public class ProfessionBO {

    private Integer id;

    /**
     * 匹配指数
     */
    private Integer match;

    /**
     * 专业名称
     */
    private String professionName;
}
