package com.douzone.HISservice.service;



import java.util.List;
import java.util.Map;

public interface PatientInfoService {

    // 특정 환자 입원 정보 READ
    List<Map<String, Object>> getPatientInfo (Map<String, Object> outInfoElement);


}
