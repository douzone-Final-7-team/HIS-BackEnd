package com.douzone.HISservice.service;

import java.util.List;
import java.util.Map;

public interface ReceiptService {

    public List<Map<String, Object>> getAdReceipt(String admissionId);

    public String setAdReceipt(Map<String, Object> test);

    List<Map<String, Object>> getAdReceiptList(Map<String, Object> filterFlag);

    void getChangeStateList();

    List<Map<String, Object>> getAdReceiptPay(Map<String, Object> test);

    List<Map<String, Object>> getBillData(String ADMISSION_ID_PK);
}
