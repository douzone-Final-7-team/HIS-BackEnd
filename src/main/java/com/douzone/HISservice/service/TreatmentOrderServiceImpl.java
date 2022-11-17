package com.douzone.HISservice.service;

import com.douzone.HISservice.repository.TreatmentOrderDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreatmentOrderServiceImpl implements TreatmentOrderService {

    private final TreatmentOrderDAO treatmentOrderDAO;

    @Override
    public void setMedicalCharts(String diagnosis, String treatmentMemo, String treatmentOrder, String medicineOrder, String admissionOrder) {
        treatmentOrderDAO.setMedicalCharts(diagnosis, treatmentMemo, treatmentOrder, medicineOrder, admissionOrder);
    }
}
