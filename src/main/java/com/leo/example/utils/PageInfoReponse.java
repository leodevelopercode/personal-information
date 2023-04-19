package com.leo.example.utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Xiexingxie
 * @date 2023/4/15 下午 08:07
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageInfoReponse {
    
    @ApiModelProperty("当前页")
    private long currentPage;
    @ApiModelProperty("页大小")
    private long pageSize;
    @ApiModelProperty("总页数")
    private long totalPage;
    @ApiModelProperty("列表数据")
    private List<?> rows;
    
    
    
}
