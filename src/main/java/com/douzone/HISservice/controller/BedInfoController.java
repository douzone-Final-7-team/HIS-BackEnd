package com.douzone.HISservice.controller;

import com.douzone.HISservice.service.BedInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admission")
@RequiredArgsConstructor
public class BedInfoController {
    private final BedInfoService bedInfoService;

    // 병동 and 호실 기준 병상 현황 정보 불러오기 READ
    @GetMapping("/roominfos")
    public List<Map<String, Object>> getBedInfos(@RequestParam Map<String, Object> roominfo) {

        return(bedInfoService.getOccupiedBedInfoList(roominfo));

    }
}
