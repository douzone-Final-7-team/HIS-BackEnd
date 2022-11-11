package com.douzone.HISservice.controller;


import com.douzone.HISservice.service.PatientInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientInfoController {

    private final PatientInfoService patientInfoService;

    // 특정 환자 입원 정보 READ
    @GetMapping("/outInfo")
    public List<Map<String, Object>>getInpatientInfo(@RequestBody Map<String, Object> outInfoElement) {

        return (patientInfoService.getPatientInfo(outInfoElement));
    }





}
