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

    // 환자 등록 정보 READ
    @PostMapping("/regInfo")
    public Map<String, Object> getPatientRegistrationInfo(@RequestBody Map<String, Object> regInfoElement) {
        System.out.println(regInfoElement);
        return (patientInfoService.getPatientRegistrationInfo(regInfoElement));
    }


    // 환자 등록 INSERT
    @PostMapping("/insert")
    public int insertPatientInfo (@RequestBody Map<String, Object> params){
        return patientInfoService.insertPatientInfo(params);
    }

    // 특정 환자 퇴원예정일 UPDATE
    @PutMapping("/dischargeDueDate")
    public void changeDischargeDueDate (@RequestBody Map<String, Object> newDischargeDate){

        patientInfoService.changeDischargeDueDate(newDischargeDate);
    }






}
