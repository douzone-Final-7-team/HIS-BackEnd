package com.douzone.HISservice.repository;

import com.douzone.HISservice.vo.TestVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StatDao {
    List<TestVo> getTestVoList();

    //String findPasswordById(String id);
}
