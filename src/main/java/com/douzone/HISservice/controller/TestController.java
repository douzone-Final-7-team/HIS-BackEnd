package com.douzone.HISservice.controller;

import com.douzone.HISservice.service.TestService;
import com.douzone.HISservice.vo.TestVo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;


    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/test")
    public List<TestVo> test() {
        return testService.getTestVoList();
    }

}
