package com.leo.example.controller;

import com.leo.example.exception.NotFoundException;
import com.leo.example.service.PeopleService;
import com.leo.example.utils.PageInfoReponse;
import com.leo.example.vo.PeopleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xiexingxie
 * @date 2023/4/14 下午 11:06
 */

@RestController
@RequestMapping("api/v1/people")
@Api(tags = "人员信息数据接口")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @ApiOperation(value = "分页查询", notes = "leo")
    @GetMapping
    public List<PeopleVo> selAllPeopleInfo() {
        throw new NotFoundException("safa");
    }

    @ApiOperation(value = "分页查询2",notes = "leo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "开始页",
            dataType = "integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "结束页",
            dataType = "integer",defaultValue = "10")
    })
    @GetMapping("selpeoplepageinfo")
    public PageInfoReponse pageInfoReponse(long currentPage,long pageSize){
        return peopleService.selPeoplePageInfo(currentPage,pageSize);
    }

    @ApiOperation(value = "删除用户信息", notes = "根据用户ID删除该用户信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userId", value = "用户ID", 
            dataType = "integer", defaultValue = "500000")
    )
    @DeleteMapping
    public int delPeopleByUserId(Integer userId) {
        return peopleService.delPeopleByUserId(userId);
    }

}

