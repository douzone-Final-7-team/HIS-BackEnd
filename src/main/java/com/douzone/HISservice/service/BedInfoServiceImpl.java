package com.douzone.HISservice.service;

import com.douzone.HISservice.repository.BedInfoDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
//별도 코드 없이 의존성 주입  private final BedImfoDAO admissionDAO 여기
public class BedInfoServiceImpl implements BedInfoService {
    private final BedInfoDAO bedInfoDAO ;

    // 병동 and 호실 기준 병상 현황 정보 불러오기 READ
    @Override
    public List<Map<String, Object>> getOccupiedBedInfoList(Map<String, Object> roominfo) {
        return bedInfoDAO.getOccupiedBedInfoList(roominfo);
    }
}
