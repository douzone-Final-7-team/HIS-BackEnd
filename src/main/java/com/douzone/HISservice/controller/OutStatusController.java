package com.douzone.HISservice.controller;

import com.douzone.HISservice.service.OutStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/outStatus")
@RequiredArgsConstructor
public class OutStatusController {

    private final OutStatusService outStatusService;

    // 접수 INSERT
    @PostMapping("/receipt")
    @ResponseBody
    public Map<String, Object> insertReceiveInfo(@RequestBody Map<String, Object> params) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("1", outStatusService.insertReceiveInfo(params));
        return response;
    }


    // 과 별 의사 리스트 SELECT
    @PostMapping("/doctorList")
    public List<Map<String, Object>> getDoctorList(@RequestBody Map<String, Object> params) {
        return outStatusService.getDoctorList(params);
    }


    // 과 별 의사 리스트와 해당 의사들의 환자 현황 SELECT
    @PostMapping("/getdocpat")
    public Object getDocPat(@RequestBody Map<String, Object> speciality) {
        List<Map<String, Object>> paramsList = outStatusService.getDoctorList(speciality);
        for(int i=0; i<paramsList.size(); i++) {
            paramsList.get(i).put("patInfo", outStatusService.getOutStatus(paramsList.get(i)));
        }
        return paramsList;
    }

    // 의사 개인 환자 현황 리스트
    @GetMapping("/MyPatient")
    public List<Map<String, Object>> getMyPatient() {
        return outStatusService.getMyPatient();
    }

    // 필터
    @PostMapping("/getdocpatCon")
    public Object getDocPatCon(@RequestBody Map<String, Object> params) {
        List<Map<String, Object>> paramsList = outStatusService.getDoctorList(params);
        for(int i=0; i<paramsList.size(); i++) {
            paramsList.get(i).put("patInfo", outStatusService.getOutStatusCon(paramsList.get(i)));
        }
        return paramsList;
    }


    // 수납 대기 환자 SELECT
    @GetMapping("/getwaiting4receipt")
    public List<Map<String, Object>> getWaiting4Receipt(@RequestParam Map<String, Object> params) {
        return outStatusService.getWaiting4Receipt(params);
    }


    // 수납 SELECT
    @PostMapping("/getAcceptance")
    public List<Map<String, Object>> getAcceptance(@RequestBody Map<String, Object> params) {
        return outStatusService.getAcceptance(params);
    }


    // 수납 금액 INSERT
    @PostMapping("/insertReceipt")
    public void insertReceipt(@RequestBody Map<String, Object> params) {
        outStatusService.insertReceipt(params);
    }
}
