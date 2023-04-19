package com.leo.example.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.example.entities.People;
import com.leo.example.repositories.PeopleRepository;
import com.leo.example.utils.PageInfoReponse;
import com.leo.example.vo.PeopleVo;
import lombok.val;
import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xiexingxie
 * @date 2023/4/14 下午 11:03
 */

@Service
public class PeopleService {

    private static final Logger logger = LoggerFactory.getLogger(PeopleService.class);
    public static final int ONE = 1;

    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    /**
     * 
     * 分页查询
     * @return
     */
    public List<PeopleVo> selAllPeopleInfo() {
        Page<People> peoplePage = new Page<>(0, 10);
        LambdaQueryWrapper<People> peopleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        return peopleRepository.selectPage(peoplePage, peopleLambdaQueryWrapper)
                .getRecords()
                .stream()
                .map(people -> {
                    PeopleVo peoplevo = new PeopleVo();
                    BeanUtils.copyProperties(people,peoplevo);
                    return peoplevo;
                })
                .collect(Collectors.toList());
    }


    public PageInfoReponse selPeoplePageInfo(long currentPage, long pageSize) {
        logger.info("开始页：{},数据量：{}",currentPage,pageSize);
        LambdaQueryWrapper<People> peopleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        Page<People> peoplePage = peopleRepository.selectPage(new Page<>(currentPage,pageSize), peopleLambdaQueryWrapper);
        val collect = peoplePage.getRecords()
                .stream()
                .map(people -> {
                    PeopleVo peopleVo = new PeopleVo();
                    BeanUtils.copyProperties(people, peopleVo);
                    return peopleVo;
                })
                .collect(Collectors.toList());
        return   PageInfoReponse
                .builder()
                .currentPage(peoplePage.getCurrent())
                .pageSize(peoplePage.getSize())
                .totalPage(peoplePage.getTotal())
                .rows(collect)
                .build(); 
        
    }



    public int delPeopleByUserId(Integer userId) {
        logger.info("用户ID为:{}的用户信息删除成功！",userId);
        return peopleRepository.deleteById(userId);
    }

}


