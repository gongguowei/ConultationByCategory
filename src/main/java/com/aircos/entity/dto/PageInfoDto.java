package com.aircos.entity.dto;

import lombok.Data;

/**
 * 分页信息
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Data
public class PageInfoDto {

    private Integer pageIndex = 1;

    private Integer pageSize = 5;
}
