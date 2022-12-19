package com.douzone.HISservice.service;

import com.douzone.HISservice.repository.ReceiptDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService{
    private final ReceiptDAO receiptDAO;

    @Override
    public List<Map<String, Object>> getAdReceiptList(Map<String, Object> filterFlag) {
        String flag = filterFlag.get("filter").toString();
        System.out.println("여기까지왔다");
        System.out.println(flag.length());
            return receiptDAO.getAdReceiptList(flag);
    }


    @Override
    public void getChangeStateList() {
        List<Map<String, Object>> chageKeyList = receiptDAO.getChangeStateList();
        System.out.println(chageKeyList.size());
        for(Map<String, Object> a : chageKeyList){
            receiptDAO.putChangeState(a);
            System.out.println(a);
        }
//        List<Map<String, Object>> chageMiddleList = receiptDAO.getChangeMiddleList();
//        System.out.println(chageMiddleList.size());
//        for(Map<String, Object> a : chageMiddleList){
//            receiptDAO.putChangeMiddle(a);
//            System.out.println(a);
//        }
    }


    @Override
    public List<Map<String, Object>> getAdReceipt(String admissionId) {
        System.out.println("qwerAll : "+receiptDAO.getAdReceipt(admissionId));
        return receiptDAO.getAdReceipt(admissionId);
    }

    public List<Map<String, Object>> getAdReceiptPay(Map<String, Object> test) {
        return receiptDAO.getAdReceiptPay(test);
    }

    @Override
    public String setAdReceipt(Map<String, Object> test) {

        int complete = 0;
        int changeState = 0;
        changeState = receiptDAO.putReceiptComplete(test); //상태값 변경

        if(changeState == 1) {
            System.out.println("update완료");
            complete = receiptDAO.setAdReceipt(test); // 입원수납정보
            if(complete == 1){
                System.out.println("insert완료");
                return "success";
            }else{
                return "completeFail";
            }
        }else{
            return "changeStateFail";
        }
    }

    public List<Map<String, Object>> getBillData(String ADMISSION_ID_PK) {
        System.out.println(ADMISSION_ID_PK);
        System.out.println("임플결과 : "+receiptDAO.getBillData(ADMISSION_ID_PK));
        return receiptDAO.getBillData(ADMISSION_ID_PK);
    }

}
