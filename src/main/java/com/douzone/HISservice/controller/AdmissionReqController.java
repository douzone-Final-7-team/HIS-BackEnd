package com.douzone.HISservice.controller;

import com.douzone.HISservice.service.AdmissionReqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admissionReq")
@RequiredArgsConstructor
public class AdmissionReqController {

    private final AdmissionReqService admissionReqService;


    // 입원 오더 리스트
    @PostMapping("/admissionOrder")
    public List<Map<String, Object>> getAdmissionOrder() {

        return (admissionReqService.getAdmissionOrder());
    }

    // 입원 승인 , 반려
    @PutMapping("/admissionAccept")
    public void putAdmissionAccept(@RequestBody Map<String, Object> admissionElement) {

        admissionReqService.putAdmissionAccept(admissionElement);

    }

    // 입원 예정 리스트
    @GetMapping("/admissionDueList")
    public List<Map<String, Object>> getAdmissionDueList() {

        return (admissionReqService.getAdmissionDueList());
    }

    // 입원 완료
    @PutMapping("/admissionComplete")
    public String putAdmissionComplete(@RequestBody Map<String, Object> admissionId) {
        admissionReqService.putAdmissionComplete(admissionId);
        return "success";
    }


}
