package com.aircos.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回给前端的专业搜索页结果
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-03
 */
@ApiModel
@Data
public class QueryProfessionVo {

    @ApiModelProperty(value = "专业名称")
    @TableField(value = "name")
    private String professionName;
}
