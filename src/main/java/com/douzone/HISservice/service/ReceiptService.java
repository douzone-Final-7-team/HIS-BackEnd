package com.douzone.HISservice.service;

import java.util.List;
import java.util.Map;

public interface ReceiptService {

    public List<Map<String, Object>> getAdReceipt(String admissionId);

    public void setAdReceipt(Map<String, Object> test);

}
