package com.douzone.HISservice.controller;


import com.douzone.HISservice.service.AdmissionHandlePageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admission")
@RequiredArgsConstructor
@Slf4j

public class AdmissionHandlePageController {
    private final AdmissionHandlePageService admissionHandlePageService;

// 간호기록

    // 특정 환자 간호기록 READ
    @PostMapping("/careInfos")
    public List<Map<String, Object>> getCareInfo(@RequestBody Map<String, Object> careInfosElements) {

        return (admissionHandlePageService.getCareInfos(careInfosElements));
    }

    // 특정 환자 간호기록 CREATE
    @PostMapping("/createdCareInfo")
    public List<Map<String, Object>> setCareInfo(@RequestBody Map<String, Object> careInfoElements) {
        try {
            admissionHandlePageService.setCareInfo(careInfoElements);
            return (admissionHandlePageService.getCareInfos(careInfoElements));
        }catch (DataIntegrityViolationException e){
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("CARE_DATE", "");
            map1.put("CARE_CONTENT", "등록이 잘못 되었습니다 다시 입력 부탁드립니다");
            map1.put("NURSE_NAME", "");
            List faultCareInfo = new ArrayList<Object>();
            faultCareInfo.add(map1);
            return faultCareInfo;
        }
    }
    // 특정 환자 간호기록 UPADTE
    @PutMapping("/changedCareInfo")
    public List<Map<String, Object>> changeCareInfo (@RequestBody Map<String, Object> upDateCareInfoElements) {
        admissionHandlePageService.changeCareInfo(upDateCareInfoElements);
        String updateResult = admissionHandlePageService.changeCareInfo(upDateCareInfoElements);

        if (updateResult == "성공") {
            return admissionHandlePageService.getCareInfos(upDateCareInfoElements);
        } else{
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("CARE_DATE", "");
            map1.put("CARE_CONTENT", "수정이 잘못 되었습니다 다시 입력 부탁드립니다");
            map1.put("NURSE_NAME", "");
            List faultCareInfo = new ArrayList<Object>();
            faultCareInfo.add(map1);
            return faultCareInfo;
        }
    };

// 처방기록

    //특정 환자별 처방기록 READ
    @PostMapping("/mediRecords")
    public List<Map<String, Object>> getMediRecords(@RequestBody Map<String, Object> mediRecordsElements) {
        return (admissionHandlePageService.getMediRecords(mediRecordsElements));
    }

    //특정 환자별 처방기록 CREATE
    @PostMapping("/createdMediRecord")
    public List<Map<String, Object>> setMediRecord(@RequestBody Map<String, Object> mediRecordElements) {
        try {
            admissionHandlePageService.setMediRecord(mediRecordElements);
            return (admissionHandlePageService.getMediRecords(mediRecordElements));
        }catch (DataIntegrityViolationException e){
            Map<String,Object> map1 = new HashMap<String, Object>();
            map1.put("RECORD_ID_PK","");
            map1.put("ORDER_CONTENT","등록이 잘못 되었습니다 다시 입력 부탁드립니다");
            map1.put("MEDICINE_NAME","");
            map1.put("ORDERER","");
            map1.put("TAKE_MEDICINE_STATUS",false);
            map1.put("ORDER_DATE","");
            List faultMediRecords = new ArrayList<Object>();
            faultMediRecords.add(map1);
            return faultMediRecords;
        }
    }
    // 특정 환자별 처방기록 UPDATE
    @PutMapping("/changedMediRecord")
    public List<Map<String, Object>> changeMediRecord (@RequestBody Map<String, Object> upDateMediRecordElements){
        admissionHandlePageService.changeMediRecord(upDateMediRecordElements);
        String updateResult =  admissionHandlePageService.changeMediRecord(upDateMediRecordElements);

        if (updateResult == "성공") {
            return admissionHandlePageService.getMediRecords(upDateMediRecordElements);
        } else{
            Map<String,Object> map1 = new HashMap<String, Object>();
            map1.put("RECORD_ID_PK","");
            map1.put("ORDER_CONTENT","수정이 잘못 되었습니다 다시 입력 부탁드립니다");
            map1.put("MEDICINE_NAME","");
            map1.put("ORDERER","");
            map1.put("TAKE_MEDICINE_STATUS",false);
            map1.put("ORDER_DATE","");
            List faultMediRecords = new ArrayList<Object>();
            faultMediRecords.add(map1);
            return faultMediRecords;
        }
    };

    // 복약 체크 시 상태 업데이트 UPDATE
    @PutMapping("/changedMediRecord/status")
    public List<Map<String, Object>> changeTakeMediStatus (@RequestBody Map<String, Object> upDateTakeMediStatusElements){
        admissionHandlePageService.changeTakeMediStatus(upDateTakeMediStatusElements);
        return  admissionHandlePageService.getMediRecords(upDateTakeMediStatusElements);
    };

// 환자 일정


    // 해당 병동 전체 환자 일정 READ
    @PostMapping("/schedules")
    public List<Map<String, Object>> getInpatientSchedules(@RequestBody Map<String, Object> inpatientSchedulesElements){
        return admissionHandlePageService.getInpatientSchedules(inpatientSchedulesElements);
    }
    // 해당 병동 전체 환자 일정 CREATE
    @PostMapping("/createdSchedule")
    public List<Map<String, Object>> setInpatientSchedule(@RequestBody Map<String, Object> inpatientScheduleElements) {
        try {
            admissionHandlePageService.setInpatientSchedule(inpatientScheduleElements);
            return admissionHandlePageService.getInpatientSchedules(inpatientScheduleElements);
        }catch (DataIntegrityViolationException e){
            Map<String,Object> map1 = new HashMap<String, Object>();
            map1.put("SCHEDULE_ID_PK","");
            map1.put("SCHEDULE_CONTENT","등록이 잘못 되었습니다 다시 입력 부탁드립니다");
            map1.put("SCHEDULE_PLACE","");
            map1.put("SCHEDULE_DATE","");
            map1.put("PS_CODE_NAME","");
            map1.put("PATIENT_NAME","");
            List faultSchedules = new ArrayList<Object>();
            faultSchedules.add(map1);
            return faultSchedules;
        }
    }
    // 해당 병동 전체 환자 일정 UPDATE
    @PutMapping("/changedSchedule")
    public List<Map<String, Object>> changeSchedule (@RequestBody Map<String, Object> upDateScheduleElements){
        admissionHandlePageService.changeSchedule(upDateScheduleElements);
        String updateResult = admissionHandlePageService.changeSchedule(upDateScheduleElements);
        if (updateResult == "성공") {
            return admissionHandlePageService.getInpatientSchedules(upDateScheduleElements);
        } else{
            Map<String,Object> map1 = new HashMap<String, Object>();
            map1.put("SCHEDULE_ID_PK","");
            map1.put("SCHEDULE_CONTENT","수정이 잘못 되었습니다 다시 입력 부탁드립니다");
            map1.put("SCHEDULE_PLACE","");
            map1.put("SCHEDULE_DATE","");
            map1.put("PS_CODE_NAME","");
            map1.put("PATIENT_NAME","");
            List faultSchedules = new ArrayList<Object>();
            faultSchedules.add(map1);
            return faultSchedules;
        }
    };

    @PutMapping("/changedSchedule/status")
    public List<Map<String, Object>> changeScheduleStatus (@RequestBody Map<String, Object> upDateScheduleStatusElements){
        admissionHandlePageService.changeScheduleStatus(upDateScheduleStatusElements);
        System.out.println("들어 오는것" + upDateScheduleStatusElements);
        System.out.println("나오는것 "+ admissionHandlePageService.getInpatientSchedules(upDateScheduleStatusElements));
        return admissionHandlePageService.getInpatientSchedules(upDateScheduleStatusElements);
    };

// 인계 사항

    // 나에게 전달 된 인계사항 READ
    @PostMapping("/toMyHandOvers")
    public List<Map<String, Object>> getReceiveHandOver(@RequestBody Map<String, Object> userName){
        return admissionHandlePageService.getReceiveHandOver(userName);

    };

    // 내가 작성한 인계사항 READ
    @PostMapping("/fromMyHandOvers")
    public List<Map<String, Object>> getSendHandOver(@RequestBody Map<String, Object> userName){
        return admissionHandlePageService.getSendHandOver(userName);
    };

    // 병동 간호사 직원목록 검색
    @PostMapping("/inNurseList")
    public List<Map<String, Object>> getInNurseList(){
        return admissionHandlePageService.getInNurseList();
    };


    // 인계 사항 CREATE
    @PostMapping("/handOver")
    public List<Map<String, Object>> setHandOver(@RequestBody Map<String, Object> handOverElements){
        try {
            admissionHandlePageService.setHandOver(handOverElements);
            return admissionHandlePageService.getSendHandOver(handOverElements);
        }catch (DataIntegrityViolationException e){
            Map<String,Object> map1 = new HashMap<String, Object>();
            map1.put("HANDOVER_ID_PK","");
            map1.put("HANDOVER_CONTENT","등록이 잘못 되었습니다 다시 입력 부탁드립니다");
            map1.put("HANDOVER_TARGET","");
            map1.put("EMP_NAME","");
            map1.put("HANDOVER_DATE","");
            List faultHandover = new ArrayList<Object>();
            faultHandover.add(map1);
            return faultHandover;
        }
    };
    // 내가 작성한 인계사항 UPDATE
    @PutMapping("/myHandOver")
    public List<Map<String, Object>> changeHandover(@RequestBody Map<String, Object> upDateHandOverElements){
        System.out.println("황동하 : "+upDateHandOverElements);
        admissionHandlePageService.changeHandover(upDateHandOverElements);
        String updateResult =  admissionHandlePageService.changeHandover(upDateHandOverElements);
        if (updateResult == "성공") {
            return admissionHandlePageService.getSendHandOver(upDateHandOverElements);
        } else{
            Map<String,Object> map1 = new HashMap<String, Object>();
            map1.put("HANDOVER_ID_PK","");
            map1.put("HANDOVER_CONTENT","수정이 잘못 되었습니다 다시 입력 부탁드립니다");
            map1.put("HANDOVER_TARGET","");
            map1.put("EMP_NAME","");
            map1.put("HANDOVER_DATE","");
            List faultHandover = new ArrayList<Object>();
            faultHandover.add(map1);
            return faultHandover;
        }

    };

    // 환자 호출

    // 로딩 시 호출 현황 READ
    @PostMapping("/allInPatientReqs")
    public List<Map<String, Object>>  getInPatientReq (@RequestBody Map<String, Object> inPatientReqElements){
        return admissionHandlePageService.getInPatientReq(inPatientReqElements);
    };


    // 환자, 간호사 소켓 요청 시 UPDATE
    @PutMapping("/InPatientReq")
    public  List<Map<String, Object>>changeInPatientReq (@RequestBody Map<String, Object> sendPatientReqElements){
        admissionHandlePageService.changeInPatientReq(sendPatientReqElements);
        return admissionHandlePageService.getInPatientReq(sendPatientReqElements);
    };

}
