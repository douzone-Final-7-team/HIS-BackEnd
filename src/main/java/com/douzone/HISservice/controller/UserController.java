package com.douzone.HISservice.controller;

import com.douzone.HISservice.config.auth.PrincipalDetails;
import com.douzone.HISservice.entity.User;
import com.douzone.HISservice.repository.UserRepository;
import com.douzone.HISservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserService userService;

    @PostMapping("/join")
    public String join(@RequestBody User user) {
        user.setPw(bCryptPasswordEncoder.encode(user.getPw()));
        user.setEmp_id_pk("D220100");
        user.setSpeciality_ID_FK("N");
        user.setEmp_name("bbs");
        user.setRole("ROLE_DOCTOR");
        user.setLicense("220100");
        user.setEmp_status("재직");
        user.setEmp_ssn("970721-1234567");
        user.setEmp_tel("010-2227-1396");
        user.setEmp_email("bbs@naver.com");
        user.setHireDate(new Date(2022-11-22));
        user.setRetireDate(null);
        user.setEmp_addr("부산시 금정구 금정로 20 래미안 장전 101동 1101호");
        userRepository.save(user);
        return "회원가입완료";
    }

    @PostMapping("/myPage")
    public List<Map<String, Object>> getMyInfo(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String username = principal.getUser().getUsername();
        System.out.println("Controller 에서 username : " + username);
        return userService.getMyInfo(username);
    }


}
