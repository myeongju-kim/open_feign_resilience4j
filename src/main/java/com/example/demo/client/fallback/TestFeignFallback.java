package com.example.demo.client.fallback;

import com.example.demo.client.TestFeignClient;
import com.example.demo.dto.LoginRequest;
import org.springframework.stereotype.Component;

@Component
public class TestFeignFallback implements TestFeignClient {

    @Override
    public String login(LoginRequest request) {
        return "10분 뒤, 다시 시도해주세요.";
    }

    @Override
    public String logout(LoginRequest request) {
        return "10분 뒤, 다시 시도해주세요.";
    }

    @Override
    public String adminLogin(LoginRequest request) {
        return request.name() + "님은 관리자가 아닙니다.";
    }
}
