package com.douzone.HISservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AdmissionFrontPageDAO {

    List<Map<String, Object>> getTest();

    List<Map<String, Object>> getDisChargeList();

    void putDisCharged(Map<String, Object> admissionId);

    List<Map<String, Object>> getMyInPatient();
}
