package com.douzone.HISservice.service;

import java.util.List;
import java.util.Map;

public interface AdmissionFrontPageService {

    List<Map<String, Object>> getBedInfo ();


    List<Map<String, Object>> getDisChargeList ();

    void putDisCharged (Map<String, Object> admissionId);

    List<Map<String, Object>> getMyInPatient(String empIdPk);

    List<Map<String, Object>> getAvailable();
}
