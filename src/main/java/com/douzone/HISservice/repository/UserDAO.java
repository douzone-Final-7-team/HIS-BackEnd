package com.douzone.HISservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDAO {

    List<Map<String, Object>> getMyInfo(String pk);

    void changePwd(String newPwd, String pk);

    void changeAddr(String newAddr, String pk);

    List<Map<String, Object>> getHeaderInfo(String pk);
}
