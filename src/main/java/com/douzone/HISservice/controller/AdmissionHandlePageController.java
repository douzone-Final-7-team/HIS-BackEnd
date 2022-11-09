package com.douzone.HISservice.controller;


import com.douzone.HISservice.service.AdmissionHandlePageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admission")
@RequiredArgsConstructor
public class AdmissionHandlePageController {

    private final AdmissionHandlePageService admissionHandlePageService;

    // 특정 환자 간호기록 READ
    @GetMapping("/careInfos")
    public List<Map<String, Object>> getCareInfo(@RequestBody Map<String, Object> careInfosElement) {

        return (admissionHandlePageService.getCareInfo(careInfosElement));

    }

    // 특정 환자 간호기록 CREATE
    @PostMapping("/careInfo")
    public String setCareInfo(@RequestBody Map<String, Object> careInfoElement) {

        admissionHandlePageService.setCareInfo(careInfoElement);
        return "인서트 성공";
    }

}
