package com.douzone.HISservice.service;

import java.util.Map;

public interface OutpatientPageService {

    // 진료메모 / 치료오더 SELECT
    Map<String, Object> getTreatmentInfos (Map<String, Object> treatmentInfosElements);
}