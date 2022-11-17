package com.douzone.HISservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TreatmentOrderDAO {

    void setMedicalCharts(String diagnosis, String treatmentMemo, String treatmentOrder, String medicineOrder, String admissionOrder);

}
