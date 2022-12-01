package com.douzone.HISservice.service;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<Map<String, Object>> getMyInfo(String pk);

    String changePwd(String newPwd, String pk);

    String changeAddr(String newAddr, String pk);

    List<Map<String, Object>> getHeaderInfo(String pk);

}
