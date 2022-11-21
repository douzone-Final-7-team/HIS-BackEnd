package com.douzone.HISservice.service;

import com.douzone.HISservice.repository.TreatmentOrderDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TreatmentOrderServiceImpl implements TreatmentOrderService {

    private final TreatmentOrderDAO treatmentOrderDAO;

    @Override
    public void setMedicalCharts(Map<String, Object> data) {
        treatmentOrderDAO.setMedicalCharts(data);

        if(Integer.parseInt(data.get("admissionCheck").toString()) == 1) {
            treatmentOrderDAO.setAdmissionDueDate(data); // 입원 오더가 내려지면 입원 테이블에 insert
        }
    }
}
