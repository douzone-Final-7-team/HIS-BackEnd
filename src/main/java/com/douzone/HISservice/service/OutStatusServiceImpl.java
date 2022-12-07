package com.douzone.HISservice.service;

import com.douzone.HISservice.repository.OutStatusDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OutStatusServiceImpl implements OutStatusService{

    private final OutStatusDAO outStatusDAO;

    // 환자 현황 전체
    @Override
    public List<Map<String, Object>> getOutStatus(Map<String, Object> outStatusElement) {
        System.out.println(outStatusElement);
        List<Map<String, Object>> outStatus = outStatusDAO.getOutStatus(outStatusElement);
        return outStatus;
    }

    @Override
    public void putChangeState(Map<String, Object> speciality) {
        outStatusDAO.putChangeState(speciality);
    }

    // 환자 현황 필터
    @Override
    public List<Map<String, Object>> getOutStatusCon(Map<String, Object> outStatusElement) {
        System.out.println(outStatusElement);
        List<Map<String, Object>> outStatus = outStatusDAO.getOutStatusCon(outStatusElement);
        return outStatus;
    }


    // 접수 INSERT
    @Override
    public int insertReceiveInfo(Map<String, Object> params){
        LocalDate now = LocalDate.now();
        String currYr = "R"+String.valueOf(now.getYear()).substring(2);
        String receiveId = getRecentSeq(currYr);

        System.out.println(params);

        System.out.println("currYr : " + currYr);
        System.out.println("receiveId : " + receiveId);

        if(receiveId == null) {
            receiveId = currYr + "000001";
        } else {
            receiveId = receiveId.replace(currYr, "");
            int receiveIdPlus = Integer.parseInt(receiveId) + 1;
            String receiveIdStr = String.valueOf(receiveIdPlus);
            for(int i=0; i<6; i++) {
                if(receiveIdStr.length() < 6) {
                    receiveIdStr = "0" + receiveIdStr;
                } else {
                    break;
                }
            }
            receiveId = currYr + receiveIdStr;
        }
        System.out.println("receiveId : " + receiveId);
        params.put("RECEIVE_ID_PK", receiveId);


        return outStatusDAO.insertReceiveInfo(params);

    }

    // 접수 최근 번호
    @Override
    public String getRecentSeq(String currYr) {
        return outStatusDAO.getRecentSeq(currYr);
    }


    // 과 별 의사 리스트
    @Override
    public List<Map<String, Object>> getDoctorList (Map<String, Object> params){
        return outStatusDAO.getDoctorList(params);
    }

    // 의사 개인 환자 현황 리스트
    @Override
    public List<Map<String, Object>> getMyPatient(String doctorID) {
        return outStatusDAO.getMyPatient(doctorID);
    }


    // 수납 대기 환자 SELECT

    @Override
    public List<Map<String, Object>> getWaiting4Receipt(Map<String, Object> params) {
        return outStatusDAO.getWaiting4Receipt(params);
    }


    // 수납 SELECT
    @Override
    public List<Map<String, Object>> getAcceptance(Map<String, Object> params) {
        return outStatusDAO.getAcceptance(params);
    }


    // 수납 금액 INSERT
    @Override
    public void insertReceipt(Map<String, Object> params) {
        System.out.println("서비스임플 params");
        System.out.println(params);
        outStatusDAO.insertReceipt(params);
        outStatusDAO.putOutStatus(params);
    }

    // 외래 환자 처방전
    @Override
    public List<Map<String, Object>> getPrescription(Map<String, Object> treatmentNumPk) {
        return outStatusDAO.getPrescription(treatmentNumPk);
    }
}
