package com.douzone.HISservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.*;

@Mapper
@Repository
public interface ReceiptDAO {
    List<Map<String, Object>> getAdReceipt(String admissionId);

    void setAdReceipt(Map<String, Object> test);



}
