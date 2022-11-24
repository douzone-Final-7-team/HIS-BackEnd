package com.douzone.HISservice.service;


import com.douzone.HISservice.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public List<Map<String, Object>> getMyInfo(String pk) {
        return userDAO.getMyInfo(pk);
    }

    @Override
    public String changePwd(String newPwd, String pk) {
        userDAO.changePwd(newPwd, pk);
        return "비밀번호를 변경하였습니다.";
    }

    @Override
    public String changeAddr(String newAddr, String pk) {
        userDAO.changeAddr(newAddr, pk);
        return "주소를 변경하였습니다.";
    }
}
