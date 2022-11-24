package com.douzone.HISservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface OutpatientPageDAO {

    // 진료메모 / 치료오더 SELECT
    Map<String, Object> getTreatmentInfos (Map<String, Object> treatmentInfosElements);
}
