package com.douzone.HISservice.repository;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BedInfoDAO {

    // 병동 and 호실 기준 병상 현황 정보 불러오기 READ
    List<Map<String, Object>> getOccupiedBedInfoList(Map<String, Object> roominfo);


}
