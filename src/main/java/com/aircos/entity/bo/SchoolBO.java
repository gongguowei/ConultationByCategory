package com.aircos.entity.bo;

import lombok.Data;

/**
 * biz object of 学校
 *
 * @author gongguowei01@gmail.com
 * @since 2020-01-28
 */
@Data
public class SchoolBO{

    private Integer id;

    /**
     * 匹配指数
     */
    private Integer match;

    /**
     * 学校名称
     */
    private String schoolName;

}
