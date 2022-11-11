package com.douzone.HISservice.controller;


import com.douzone.HISservice.service.AdmissionHandlePageService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admission")
@RequiredArgsConstructor


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
    public String setCareInfo(@RequestBody Map<String, Object> careInfoElements) {

        admissionHandlePageService.setCareInfo(careInfoElements);
        return "간호 기록 인서트 성공";
    }
    // 특정 환자 간호기록 UPADTE
    @PutMapping("/changedCareInfo")
    public String changeCareInfo (@RequestBody Map<String, Object> upDateCareInfoElements){
        admissionHandlePageService.changeCareInfo(upDateCareInfoElements);

        return "간호 기록 업데이트 성공";
    };

// 처방기록

    //특정 환자별 처방기록 READ
    @PostMapping("/mediRecords")
    public List<Map<String, Object>> getMediRecords(@RequestBody Map<String, Object> mediRecordsElements) {

        return (admissionHandlePageService.getMediRecords(mediRecordsElements));


    }


    //특정 환자별 처방기록 CREATE
    @PostMapping("/createdMediRecord")
    public String setMediRecord(@RequestBody Map<String, Object> mediRecordElements) {

        admissionHandlePageService.setMediRecord(mediRecordElements);
        return "처방기록 인서트 성공";
    }
    // 특정 환자별 처방기록 UPDATE
    @PutMapping("/changedMediRecord")
    public String changeMediRecord (@RequestBody Map<String, Object> upDateMediRecordElements){
        admissionHandlePageService.changeMediRecord(upDateMediRecordElements);

        return  "특정 환자별 처방기록 UPDATE";
    };

    // 복약 체크 시 상태 업데이트 UPDATE
    @PutMapping("/changedMediRecord/status")
    public String changeTakeMediStatus (@RequestBody Map<String, Object> upDateTakeMediStatusElements){
        admissionHandlePageService.changeTakeMediStatus(upDateTakeMediStatusElements);
        return "복약 체크 시 상태 업데이트 UPDATE";
    };

// 환자 일정


    // 해당 병동 전체 환자 일정 READ
    @PostMapping("/schedules")
    public List<Map<String, Object>> getInpatientSchedules(@RequestBody Map<String, Object> inpatientSchedulesElements){
        return admissionHandlePageService.getInpatientSchedules(inpatientSchedulesElements);
    }
    // 해당 병동 전체 환자 일정 CREATE
    @PostMapping("/createdSchedule")
    public String setInpatientSchedule(@RequestBody Map<String, Object> inpatientScheduleElements) {
        admissionHandlePageService.setInpatientSchedule(inpatientScheduleElements);

        return "환자 일정 인서트 성공";
    }
    // 해당 병동 전체 환자 일정 UPDATE
    @PutMapping("/changedSchedule")
    public String changeSchedule (@RequestBody Map<String, Object> upDateScheduleElements){
        admissionHandlePageService.changeSchedule(upDateScheduleElements);
        return "해당 병동 전체 환자 일정 UPDATE";
    };

    // 해당 병동 전체 환자 일정 상태 UPDATE
    @PutMapping("/changedSchedule/status")
    public String changeScheduleStatus (@RequestBody Map<String, Object> upDateScheduleStatusElements){
        admissionHandlePageService.changeScheduleStatus(upDateScheduleStatusElements);
        return "해당 병동 전체 환자 일정 상태 UPDATE";
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


    // 인계 사항 CREATE
    @PostMapping("/handOver")
    public String setHandOver(@RequestBody Map<String, Object> handOverElements){

            try {
                admissionHandlePageService.setHandOver(handOverElements);
                return "인계 사항  인서트 성공";
            }catch (DataIntegrityViolationException e){
                return "잘못 입력 된 직원명입니다";
            }

    };

    // 내가 작성한 인계사항 UPDATE
    @PutMapping("/myHandOver")
    public String changeHandover(@RequestBody Map<String, Object> upDateHandOverElements){
        admissionHandlePageService.changeHandover(upDateHandOverElements);
        return "인계 사항 업데이트 성공";
    };

    // 환자 호출

    // 로딩 시 호출 현황 READ
    @PostMapping("/allOutPatientReqs")
    public List<Map<String, Object>>  getOutPatientReq (@RequestBody Map<String, Object> outPatientReqElements){
        return admissionHandlePageService.getOutPatientReq(outPatientReqElements);
    };


    // 환자, 간호사 소켓 요청 시 UPDATE
    @PutMapping("/OutPatientReq")
    public  String changeOutPatientReq (@RequestBody Map<String, Object> sendPatientReqElements){
        admissionHandlePageService.changeOutPatientReq(sendPatientReqElements);
        return "업데이트 성공";
    };

}
