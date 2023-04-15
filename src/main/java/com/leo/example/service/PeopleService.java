package com.leo.example.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.example.entities.People;
import com.leo.example.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xiexingxie
 * @date 2023/4/14 下午 11:03
 */

@Service
public class PeopleService {
    
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> selAllPeopleInfo(){
        Page<People> peoplePage = new Page<>(0,10);
        LambdaQueryWrapper<People> peopleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        IPage<People> peoplePage1 = peopleRepository.selectPage(peoplePage, peopleLambdaQueryWrapper);
        List<People> collect = peoplePage1.getRecords().stream()
                .distinct()
                .collect(Collectors.toList());
        return collect;        
    } 
    
}


