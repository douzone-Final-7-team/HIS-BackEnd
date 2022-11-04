package com.douzone.HISservice.service;

import com.douzone.HISservice.repository.StatDao;
import com.douzone.HISservice.vo.TestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TestServiceImpl implements TestService{
    private final StatDao statDao;

    @Override
    public List<TestVo> getTestVoList(){
        return  statDao.getTestVoList();
    }



}
