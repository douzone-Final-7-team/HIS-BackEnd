package com.douzone.HISservice.service;


import com.douzone.HISservice.repository.AdmissionReqDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdmissionReqServiceImpl implements AdmissionReqService {
    private final AdmissionReqDAO admissionReqDAO;

    // 입원 오더 리스트
    @Override
    public List<Map<String, Object>> getAdmissionOrder (){
        return admissionReqDAO.getAdmissionOrder();
    }

    // 입원 승인
    @Override
    public void putAdmissionAccept (Map<String, Object> admissionElement){
        String admissionResult = admissionElement.get("BTN_STATE").toString();
//        System.out.println(admissionResult);
        if(admissionResult.equals("assign")){
            admissionReqDAO.putAdmissionAccept(admissionElement);
            admissionReqDAO.putBedStatusIn(admissionElement);
        }else{
            admissionReqDAO.putAdmissionNotAccept(admissionElement);
        }
    }

    // 입원 오더 리스트
    @Override
    public List<Map<String, Object>> getAdmissionDueList (){
        return admissionReqDAO.getAdmissionDueList();
    }

    @Override
    public void putAdmissionComplete (Map<String, Object> admissionId) {
        admissionReqDAO.putAdmissionComplete(admissionId);
    }



}
