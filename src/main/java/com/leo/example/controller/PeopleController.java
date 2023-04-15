package com.leo.example.controller;

import com.leo.example.entities.People;
import com.leo.example.service.PeopleService;
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
public class PeopleController {
    
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<People> selAllPeopleInfo(){
        return peopleService.selAllPeopleInfo();
    }
    
}

