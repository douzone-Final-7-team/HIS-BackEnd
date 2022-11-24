package com.douzone.HISservice.controller;

import com.douzone.HISservice.config.auth.PrincipalDetails;
import com.douzone.HISservice.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserInfoService userService;

    @PostMapping("/myPage")
    public List<Map<String, Object>> getMyInfo(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String username = principal.getUser().getUsername();
        System.out.println("Controller 에서 username : " + username);
        return userService.getMyInfo(username);
    }
}
