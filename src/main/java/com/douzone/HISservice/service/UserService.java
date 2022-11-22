package com.douzone.HISservice.service;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<Map<String, Object>> getMyInfo(String username);

}
