package com.douzone.HISservice.service;


import com.douzone.HISservice.repository.AdmissionHandlePageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdmissionHandlePageServiceImpl implements  AdmissionHandlePageService{

    private final AdmissionHandlePageDAO admissionHandlePageDAO;


    // 특정 환자 간호기록 READ
    @Override
    public List<Map<String, Object>>  getCareInfo (Map<String, Object> careInfosElement){

        return admissionHandlePageDAO.getCareInfo(careInfosElement);
    }

    // 특정 환자 간호기록 CREATE
    @Override
    public void setCareInfo (Map<String, Object> careInfoElement){

        admissionHandlePageDAO.setCareInfo(careInfoElement);
    }
}
