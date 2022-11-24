package com.douzone.HISservice.service;

import java.util.List;
import java.util.Map;

public interface AdmissionFrontPageService {

    List<Map<String, Object>> getTest ();


    List<Map<String, Object>> getDisChargeList ();

    void putDisCharged (Map<String, Object> admissionId);
}
