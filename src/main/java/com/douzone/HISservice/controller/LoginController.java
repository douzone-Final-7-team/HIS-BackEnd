package com.douzone.HISservice.controller;


import com.douzone.HISservice.entity.User;
import com.douzone.HISservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    @PostMapping("/doctor/treatment")
    public String treatment() {
        return "<h1>의사 진료 view 입니다.</h1>";
    }

    @PostMapping("/inNurse/ward")
    public String cure() {
        return "<h1>병동간호사 병동 관리 view 입니다.</h1>";
    }

    @PostMapping("/receipt/receiption")
    public String receipt() {
        return "<h1>원무 접수/수납 view 입니다.</h1>";
    }

    @PostMapping("join")
    public String join(@RequestBody User user) {
        user.setPw(bCryptPasswordEncoder.encode(user.getPw()));
        user.setRole("ROLE_DOCTOR");
        user.setEmp_email("bbs@naver.com");
        user.setEmp_addr("부산 광역시 금정구 금정로20");
        user.setEmp_ssn("970721-1865467");
        user.setEmp_name("배병서");
        user.setLicense("220025");
        user.setEmp_status("재직");
        user.setEmp_id_pk("D220022");
        user.setSpeciality_ID_FK("N");
        user.setEmp_tel("010-2227-1396");
        user.setHireDate(Date.valueOf("2022-11-09"));
        userRepository.save(user);
        return "회원가입완료";
    }
}
