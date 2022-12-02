package com.douzone.HISservice.controller;

import com.douzone.HISservice.service.OutpatientPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/outpatient")
@RequiredArgsConstructor
public class OutpatientPageController {

    private final OutpatientPageService outpatientPageService;
    // 진료메모 / 치료오더 SELECT
    @PostMapping ("/treatmentInfos")
    public Map<String, Object> getTreatmentInfos(@RequestBody Map<String, Object> treatmentInfosElements) {
        return (outpatientPageService.getTreatmentInfos(treatmentInfosElements));
    }

    // 외래진료환자 상태코드 변경 UPDATE
    @PutMapping("/changeOutpatientStatus")
    public void changeOutpatientStatus(@RequestBody Map<String, Object> updateCodeElements) {
        outpatientPageService.changeOutpatientStatus(updateCodeElements);
    }
}
