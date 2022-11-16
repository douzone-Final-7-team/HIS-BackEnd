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
    @PostMapping("/outInfo")
    public Map<String, Object> getInpatientInfo(@RequestBody Map<String, Object> outInfoElement) {

        return (patientInfoService.getPatientInfo(outInfoElement));
    }

    // 특정 환자 퇴원예정일 UPDATE
    @PutMapping("/dischargeDueDate")
    public void changeDischargeDueDate (@RequestBody Map<String, Object> newDischargeDate){

        patientInfoService.changeDischargeDueDate(newDischargeDate);
    }

    // 진료환자 과거 병력 조회
    @GetMapping("/pastTreatment")
    public List<Map<String, Object>> getPastTreatment() {

        return patientInfoService.getPastTreatment();
    }


}
