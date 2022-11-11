package com.douzone.HISservice.service;


import java.util.List;
import java.util.Map;

public interface BedInfoService {

    // 병동 and 호실 기준 병상 현황 정보 불러오기 READ
    public List<Map<String, Object>> getOccupiedBedInfoList (Map<String, Object> roominfo);

}
