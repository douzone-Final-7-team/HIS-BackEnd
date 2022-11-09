package com.douzone.HISservice.service;



import java.util.List;
import java.util.Map;

public interface AdmissionHandlePageService {

    // 특정 환자 간호기록 READ
    public List<Map<String, Object>>  getCareInfo (Map<String, Object> careInfosElement);

    // 특정 환자 간호기록 CREATE
    public void setCareInfo (Map<String, Object> careInfoElement);
}
