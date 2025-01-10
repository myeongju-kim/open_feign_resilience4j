package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/test")
@RequiredArgsConstructor
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping("/login")
    public CommonResponse<String> getMessageByLoginServer(@RequestParam String name) {
        return testService.getMessageByLoginServer(name);
    }

    @GetMapping("/logout")
    public CommonResponse<String> getMessageByLogoutServer(@RequestParam String name) {
        return testService.getMessageByLogoutServer(name);
    }

    @GetMapping("/admin")
    public CommonResponse<String> getMessageByAdminServer(@RequestParam String name) {
        return testService.getMessageByAdminServer(name);
    }
}
