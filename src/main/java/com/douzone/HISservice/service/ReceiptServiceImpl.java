package com.douzone.HISservice.service;

import com.douzone.HISservice.repository.ReceiptDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService{
    private final ReceiptDAO receiptDAO;

    @Override
    public List<Map<String, Object>> getAdReceipt(String admissionId) {
        return receiptDAO.getAdReceipt(admissionId);
    }

    @Override
    public void setAdReceipt(Map<String, Object> test) {
        System.out.println("Impl : " + test.get("ADMISSION_ID_FK").toString());
        receiptDAO.setAdReceipt(test);
    }


}
