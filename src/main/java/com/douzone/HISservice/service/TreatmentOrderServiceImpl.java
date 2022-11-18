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
    }
}
