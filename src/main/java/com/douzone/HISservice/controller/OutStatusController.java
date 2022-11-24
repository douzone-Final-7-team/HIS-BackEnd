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


    // // 과 별 의사 리스트와 해당 의사들의 환자 현황 SELECT
    @PostMapping("/getdocpat")
    public Object getDocPat(@RequestBody Map<String, Object> speciality) {
        List<Map<String, Object>> paramsList = outStatusService.getDoctorList(speciality);
        for(int i=0; i<paramsList.size(); i++) {
            paramsList.get(i).put("patInfo", outStatusService.getOutStatus(paramsList.get(i)));
        }
        return paramsList;
    }

    // 수납 금액 SELECT
}
