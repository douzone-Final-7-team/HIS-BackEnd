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
        System.out.println(flag);
        if(flag.equals("today")) {
            System.out.println("fffff");
            return receiptDAO.getAdReceiptListToday();
        }else if(flag.equals("middlePayment")){
            System.out.println("qqqqqq");
            return receiptDAO.getMiddlePaymentList();
        }else{
            System.out.println("pppppp");
            System.out.println("tlqkftlqkf : "+receiptDAO.getAdReceiptListAll());
            return receiptDAO.getAdReceiptListAll();
        }
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
        //이부분이 콘솔에 찍힐꺼야
        // ㅇㅋ? 잠만
//        System.out.println("qwersize : "+receiptDAO.getAdReceipt(admissionId).size());
        return receiptDAO.getAdReceipt(admissionId);
    }

    @Override
    public void setAdReceipt(Map<String, Object> test) {
        System.out.println("all : " + test);
        System.out.println("Impl : " + test.get("ADMISSION_ID_PK").toString());
        System.out.println("Impl : " + test.get("ADMISSION_STATUS_CODE").toString());
        System.out.println("Impl : " + test.get("MIDDLE_PAY_DATE"));
        System.out.println("------------------------------------------------");
        receiptDAO.setAdReceipt(test); // 입원수납정보
        System.out.println("insert완료");
        receiptDAO.putReceiptComplete(test); //상태값 변경
        System.out.println("update완료");

    }


}
