package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/members")
@RequiredArgsConstructor
@RestController
public class MemberController {

    @PostMapping("/login")
    public String loginMember(@RequestBody LoginRequest request) {
        return request.name() + "님, 안녕하세요! 로그인 확인되었습니다. :D";
    }

    @PostMapping("/logout")
    public String logoutMember(@RequestBody LoginRequest request) {
        return request.name() + "님, 안녕히가세요! 로그아웃되었습니다. :ㅁ";
    }


    @PostMapping("/admin/login")
    public String loginAdmin(@RequestBody LoginRequest request) {
        if (!"킹명주".equals(request.name())) {
            throw new RuntimeException();
        }

        return request.name() + "님, 관리자페이지 접근완료되었습니다. :>";
    }
}
