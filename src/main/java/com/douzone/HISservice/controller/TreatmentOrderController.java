package com.douzone.HISservice.controller;

import com.douzone.HISservice.service.AdmissionFrontPageService;
import com.douzone.HISservice.service.TreatmentOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/treatmentOrder")
@RequiredArgsConstructor
public class TreatmentOrderController {

    private final TreatmentOrderService treatmentOrderService;

    @PostMapping("/treatmentDone")
    public String setMedicalCharts(@RequestBody Map<String, Object> data){
        System.out.println(data);
        System.out.println(data.get("admissionOrder"));
        System.out.println(data.get("admissionCheck"));
        treatmentOrderService.setMedicalCharts(data);
        return "데이터 받음";
    }
}
