package com.douzone.HISservice.controller;

import com.douzone.HISservice.service.AdmissionFrontPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AdmissionFront")
@RequiredArgsConstructor
public class AdmissionFrontPageController {

    private final AdmissionFrontPageService adFrontService;

    // 병동 원무 병상 정보
    @GetMapping("/test")
    public List<Map<String, Object>> getTest() {

        return(adFrontService.getTest());

    }

    @GetMapping("/dischargelist")
    public List<Map<String, Object>> getDisChargeList() {

        return(adFrontService.getDisChargeList());

    }

    @PutMapping("/discharged")
    public void putDisChargeList(@RequestBody Map<String, Object> admissionId) {

        adFrontService.putDisChargeList(admissionId);

    }



}
