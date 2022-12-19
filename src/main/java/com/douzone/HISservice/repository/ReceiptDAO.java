package com.douzone.HISservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.*;

@Mapper
@Repository
public interface ReceiptDAO {
    // 퇴원예정일
    List<Map<String, Object>> getChangeStateList();
    void putChangeState(Map<String, Object> a);

    List<Map<String, Object>> getChangeMiddleList();
    void putChangeMiddle(Map<String, Object> a);



    List<Map<String, Object>> getAdReceipt(String admissionId);

    int putReceiptComplete(Map<String, Object> test);

    int setAdReceipt(Map<String, Object> test);

    List<Map<String, Object>> getAdReceiptPay(Map<String, Object> test);

    List<Map<String, Object>> getAdReceiptList(String filterFlag);


    List<Map<String, Object>> getBillData(String ADMISSION_ID_PK);
}
