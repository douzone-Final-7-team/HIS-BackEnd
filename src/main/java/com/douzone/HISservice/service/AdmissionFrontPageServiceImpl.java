package com.douzone.HISservice.service;

import com.douzone.HISservice.repository.AdmissionFrontPageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdmissionFrontPageServiceImpl implements AdmissionFrontPageService{
    private final AdmissionFrontPageDAO admissionFrontPageDAO;

    @Override
    public List<Map<String, Object>> getTest() {

        return admissionFrontPageDAO.getTest();
    }


    @Override
    public List<Map<String, Object>> getDisChargeList() {

        return admissionFrontPageDAO.getDisChargeList();
    }


//    @Override
//    public List<Map<String, Object>> putDisChargeList(Map<String, Object> admissionId) {
//
//        return adFrontDAO.putDisChargeList(admissionId);
//    }
    @Override
    public void putDisCharged(Map<String, Object> admissionId) {

        admissionFrontPageDAO.putDisCharged(admissionId);
    }


}
