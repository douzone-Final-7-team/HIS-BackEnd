package com.douzone.HISservice.repository;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PatientInfoDAO {

    // 특정 환자 입원 정보 READ
    Map<String, Object> getPatientInfo (Map<String, Object> outInfoElement);

    // 특정 환자 퇴원예정일 UPDATE
    void changeDischargeDueDate (Map<String, Object> newDischargeDate);

    List<Map<String, Object>> getPastTreatment();

}
