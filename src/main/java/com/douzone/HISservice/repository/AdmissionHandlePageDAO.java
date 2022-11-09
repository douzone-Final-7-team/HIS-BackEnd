package com.douzone.HISservice.repository;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AdmissionHandlePageDAO {

    // 특정 환자 간호기록 READ
    List<Map<String, Object>>  getCareInfo (Map<String, Object> careInfosElement);

    // 특정 환자 간호기록 CREATE
    void setCareInfo (Map<String, Object> careInfoElement);
}
