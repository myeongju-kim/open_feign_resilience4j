package com.example.demo.service;

import com.example.demo.client.TestFeignClient;
import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.LoginRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Service
public class TestService {

    private final TestFeignClient testFeignClient;

    public CommonResponse<String> getMessageByLoginServer(String name) {
        if (!StringUtils.hasText(name)) {
            return CommonResponse.fail(400, "이름은 비어있을 수 없습니다.");
        }
        LoginRequest loginRequest = new LoginRequest(name);
        String loginMessage = testFeignClient.login(loginRequest);

        return CommonResponse.success(loginMessage);
    }

    public CommonResponse<String> getMessageByLogoutServer(String name) {
        if (!StringUtils.hasText(name)) {
            return CommonResponse.fail(400, "이름은 비어있을 수 없습니다.");
        }
        LoginRequest loginRequest = new LoginRequest(name);
        String loginMessage = testFeignClient.logout(loginRequest);

        return CommonResponse.success(loginMessage);
    }

    @CircuitBreaker(name = "testCircuitBreaker", fallbackMethod = "fallback")
    public CommonResponse<String> getMessageByAdminServer(String name) {
        if (!StringUtils.hasText(name)) {
            return CommonResponse.fail(400, "이름은 비어있을 수 없습니다.");
        }
        LoginRequest loginRequest = new LoginRequest(name);
        String loginMessage = testFeignClient.adminLogin(loginRequest);

        return CommonResponse.success(loginMessage);
    }
}
