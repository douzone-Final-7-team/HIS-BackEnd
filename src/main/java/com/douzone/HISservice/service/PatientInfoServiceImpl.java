package com.douzone.HISservice.service;


import com.douzone.HISservice.repository.PatientInfoDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PatientInfoServiceImpl implements PatientInfoService {
    private final PatientInfoDAO patientInfoDAO;

    // 특정 환자 입원 정보 READ
    @Override
    public List<Map<String, Object>> getPatientInfo (Map<String, Object> outInfoElement){
        return patientInfoDAO.getPatientInfo(outInfoElement);
    }
}
