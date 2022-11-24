package com.douzone.HISservice.controller;

import com.douzone.HISservice.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/AdmissionReceipt")
@RequiredArgsConstructor
public class ReceiptController {
    private final ReceiptService receiptService;

    @PostMapping("/AdReceipt")
    public List<Map<String, Object>> getAdReceipt(@RequestBody Map<String, Object> test) {
        String admissionId = test.get("ADMISSION_ID_FK").toString();
        return(receiptService.getAdReceipt(admissionId));

    }

    @PutMapping("/AdReceiptComplete")
    public void setAdReceipt(@RequestBody Map<String, Object> test) {

        String q = test.get("ADMISSION_ID_FK").toString();
        System.out.println(q);
        receiptService.setAdReceipt(test);
//        return(receiptService.setAdReceipt(test));

    }


}
