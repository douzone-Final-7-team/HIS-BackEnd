package com.douzone.HISservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface TreatmentOrderDAO {

    void setMedicalCharts(Map<String, Object> data);

}
