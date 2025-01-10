package com.example.demo.client;

import com.example.demo.dto.LoginRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "members", url = "http://localhost:8080/members/")
public interface TestFeignClient {

    @PostMapping("/login")
    String login(@RequestBody LoginRequest request);

    @PostMapping("/logout")
    String logout(@RequestBody LoginRequest request);

    @PostMapping("/admin/login")
    @CircuitBreaker(name = "testCircuitBreaker", fallbackMethod = "fallback")
    String adminLogin(@RequestBody LoginRequest request);

    default String fallback(LoginRequest request) {
        return request.name() + "님은 관리자가 아닙니다.";
    }
}
