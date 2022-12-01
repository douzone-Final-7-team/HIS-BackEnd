package com.douzone.HISservice.service;

import java.util.List;
import java.util.Map;

public interface OutStatusService {

    // 환자 현황 READ
    List<Map<String, Object>> getOutStatus (Map<String, Object> outStatusElement);


    // 접수 INSERT
    int insertReceiveInfo(Map<String, Object> params);

    // 최근접수번호 id(R22~~) SELECT
    String getRecentSeq(String currYr);


    // 과 별 의사 리스트와 해당 의사들의 환자 현황 SELECT
    List<Map<String, Object>>  getDoctorList (Map<String, Object> params);


    // 의사 개인 환자 현황 리스트
    List<Map<String, Object>> getMyPatient ();


    // 수납 금액 SELECT

}
