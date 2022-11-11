package com.douzone.HISservice.repository;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AdmissionReqDAO {

    // 입원 오더 리스트
    List<Map<String, Object>> getAdmissionOrder ();

    // 입원 승인
    void putAdmissionAccept(Map<String, Object> admissionElement);

    void putBedStatusIn(Map<String, Object> admissionElement);

    // 입원 반려
    void putAdmissionNotAccept(Map<String, Object> admissionElement);


    List<Map<String, Object>> getAdmissionDueList();

    void putAdmissionComplete(Map<String, Object> admissionId);
}
