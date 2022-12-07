package com.douzone.HISservice.service;

import com.douzone.HISservice.repository.TreatmentOrderDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TreatmentOrderServiceImpl implements TreatmentOrderService {

    private final TreatmentOrderDAO treatmentOrderDAO;

    @Override
    public void setMedicalCharts(Map<String, Object> data) {
        treatmentOrderDAO.setMedicalCharts(data);
        treatmentOrderDAO.setOutpatientStatus(data);
        if(Integer.parseInt(data.get("admissionCheck").toString()) == 1) {
            treatmentOrderDAO.setAdmissionDueDate(data); // 입원 오더가 내려지면 입원 테이블에 insert
        }
    }

    @Override
    public List<Map<String, Object>> getDiagnosisList(String specialityId) {
        return treatmentOrderDAO.getDiagnosisList(specialityId);
    }

    @Override
    public List<Map<String, Object>> getMedicineList(String diagnosis) {
        return treatmentOrderDAO.getMedicineList(diagnosis);
    }
}
