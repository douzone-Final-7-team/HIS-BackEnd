package com.douzone.HISservice.service;

import java.util.List;
import java.util.Map;

public interface AdmissionFrontPageService {

    List<Map<String, Object>> getTest ();


    List<Map<String, Object>> getDisChargeList ();

    void putDisChargeList (Map<String, Object> admissionId);

    List<Map<String, Object>> getMyInPatient ();


}
