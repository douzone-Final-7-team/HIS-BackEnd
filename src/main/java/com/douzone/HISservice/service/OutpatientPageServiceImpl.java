package com.douzone.HISservice.service;

import com.douzone.HISservice.repository.OutpatientPageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OutpatientPageServiceImpl implements OutpatientPageService {

    private final OutpatientPageDAO outpatientPageDAO;

    // 진료메모 / 치료오더 SELECT
    @Override
    public Map<String, Object> getTreatmentInfos (Map<String, Object> treatmentInfosElements){
        System.out.println(treatmentInfosElements);
        return outpatientPageDAO.getTreatmentInfos(treatmentInfosElements);
    }
}
