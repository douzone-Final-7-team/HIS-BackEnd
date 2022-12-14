package com.douzone.HISservice.controller;

import com.douzone.HISservice.config.auth.PrincipalDetails;
import com.douzone.HISservice.service.AdmissionFrontPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AdmissionFront")
@RequiredArgsConstructor
public class AdmissionFrontPageController {

    private final AdmissionFrontPageService adFrontService;

    // 병동 원무 병상 정보
    @GetMapping("/bedInfo")
    public List<Map<String, Object>> getBedInfo() {

        return(adFrontService.getBedInfo());

    }

    @GetMapping("/dischargelist")
    public List<Map<String, Object>> getDisChargeList() {

        return(adFrontService.getDisChargeList());

    }

    @PutMapping("/discharged")
    public String putDisCharged(@RequestBody Map<String, Object> admissionId) {

        return (adFrontService.putDisCharged(admissionId));

    }

    // 내 입원환자 정보
    @GetMapping("/myInPatient")
    public List<Map<String, Object>> getMyInPatient(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String empIdPk = principal.getUser().getEmp_id_pk();
        return adFrontService.getMyInPatient(empIdPk);

    }

    @GetMapping("/available_room")
    public List<Map<String, Object>> getAvailable() {
        System.out.println("구구구구구구콘맛있겠다 : " +adFrontService.getAvailable());
        return adFrontService.getAvailable();

    }



}
