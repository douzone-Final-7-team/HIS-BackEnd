package com.douzone.HISservice.service;


import com.douzone.HISservice.repository.AdmissionHandlePageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdmissionHandlePageServiceImpl implements  AdmissionHandlePageService{

    private final AdmissionHandlePageDAO admissionHandlePageDAO;

// 간호기록

    // 특정 환자 간호기록 READ
    @Override
    public List<Map<String, Object>>  getCareInfos (Map<String, Object> careInfosElements){
        if(admissionHandlePageDAO.getCareInfos(careInfosElements).isEmpty()){
            Map<String,Object> map1 = new HashMap<String, Object>();
            map1.put("CARE_DATE","");
            map1.put("CARE_CONTENT","빈 데이터 입니다 환자를 클릭 하세요");
            map1.put("NURSE_NAME","");
            List list = new ArrayList<Object>();
            list.add(map1);
            return list;
        }else{
            return admissionHandlePageDAO.getCareInfos(careInfosElements);
        }
    }

    // 특정 환자 간호기록 CREATE
    @Override
    public void setCareInfo (Map<String, Object> careInfoElements){
        admissionHandlePageDAO.setCareInfo(careInfoElements);
    }
    // 특정 환자 간호기록 UPADTE
    @Override
    public String changeCareInfo (Map<String, Object> upDateCareInfoElements){
        admissionHandlePageDAO.changeCareInfo(upDateCareInfoElements);

        if(admissionHandlePageDAO.changeCareInfo(upDateCareInfoElements) ==0){
            return "실패";
        }else {
            return "성공";
        }
    };

// 처방기록

    //특정 환자별 처방기록 READ
    @Override
    public List<Map<String, Object>>  getMediRecords (Map<String, Object> mediRecordsElements){
        if(admissionHandlePageDAO.getMediRecords(mediRecordsElements).isEmpty()){
            Map<String,Object> map1 = new HashMap<String, Object>();
            map1.put("RECORD_ID_PK","");
            map1.put("ORDER_CONTENT","빈 데이터 입니다 환자를 클릭 하세요");
            map1.put("MEDICINE_NAME","");
            map1.put("ORDERER","");
            map1.put("TAKE_MEDICINE_STATUS",false);
            map1.put("ORDER_DATE","");
            List list = new ArrayList<Object>();
            list.add(map1);
            return list;
        }else{
            return admissionHandlePageDAO.getMediRecords(mediRecordsElements);
        }
    }

    //특정 환자별 처방기록 CREATE
    @Override
    public void setMediRecord (Map<String, Object> mediRecordElements){
        admissionHandlePageDAO.setMediRecord(mediRecordElements);
    }

    // 특정 환자별 처방기록 UPDATE
    @Override
    public String changeMediRecord (Map<String, Object> upDateMediRecordElements){
        admissionHandlePageDAO.changeMediRecord(upDateMediRecordElements);
        if(admissionHandlePageDAO.changeMediRecord(upDateMediRecordElements) ==0){
            return "실패";
        }else {
            return "성공";
        }
    };

    // 복약 체크 시 상태 업데이트 UPDATE
    @Override
    public void changeTakeMediStatus (Map<String, Object> upDateTakeMediStatusElements){
        admissionHandlePageDAO.changeTakeMediStatus(upDateTakeMediStatusElements);
    };

// 환자 일정

    // 해당 병동 전체 환자 일정 READ
    @Override
    public List<Map<String, Object>>  getInpatientSchedules (Map<String, Object> inpatientSchedulesElements){
        LocalDate now = LocalDate.now();
        if(inpatientSchedulesElements.get("searchDate") == null) {
            inpatientSchedulesElements.put("searchDate", now);
        }
        return admissionHandlePageDAO.getInpatientSchedules(inpatientSchedulesElements);
    }
    // 해당 병동 전체 환자 일정 CREATE
    @Override
    public void setInpatientSchedule (Map<String, Object> inpatientScheduleElements){
         admissionHandlePageDAO.setInpatientSchedule(inpatientScheduleElements);
    }

    // 해당 병동 전체 환자 일정 UPDATE
    @Override
    public String changeSchedule (Map<String, Object> upDateScheduleElements){
        admissionHandlePageDAO.changeSchedule(upDateScheduleElements);
        if(admissionHandlePageDAO.changeSchedule(upDateScheduleElements) ==0){
            return "실패";
        }else {
            return "성공";
        }
    };

    // 해당 병동 전체 환자 일정 상태 UPDATE
    @Override
    public void changeScheduleStatus (Map<String, Object> upDateScheduleStatusElements){
        admissionHandlePageDAO.changeScheduleStatus(upDateScheduleStatusElements);
    };

// 인계 사항

    // 나에게 전달 된 인계사항 READ
    @Override
    public List<Map<String, Object>>  getReceiveHandOver (Map<String, Object> userName){
        return admissionHandlePageDAO.getReceiveHandOver(userName);
    };

    // 내가 작성한 인계사항 READ
    @Override
    public List<Map<String, Object>>  getSendHandOver (Map<String, Object> userName){
        return admissionHandlePageDAO.getSendHandOver(userName);
    };
    @Override
    public List<Map<String, Object>> getInNurseList(){
        return admissionHandlePageDAO.getInNurseList();
    };



    // 인계 사항 CREATE
    @Override
    public void setHandOver (Map<String, Object> handOverElements){
        admissionHandlePageDAO.setHandOver(handOverElements);
    };

    // 내가 작성한 인계사항 UPDATE
    @Override
    public String changeHandover (Map<String, Object> upDateHandOverElements){
        admissionHandlePageDAO.changeHandover(upDateHandOverElements);
        if(admissionHandlePageDAO.changeHandover(upDateHandOverElements) ==0){
            return "실패";
        }else {
            return "성공";
        }
    };

// 환자 호출

    // 로딩 시 호출 현황 READ
    @Override
    public List<Map<String, Object>>  getInPatientReq (Map<String, Object> inPatientReqElements){
        return admissionHandlePageDAO.getInPatientReq(inPatientReqElements);
    };


    // 환자, 간호사 소켓 요청 시 UPDATE
    @Override
    public  void changeInPatientReq (Map<String, Object> sendPatientReqElements) {
        admissionHandlePageDAO.changeInPatientReq(sendPatientReqElements);
    };

}
