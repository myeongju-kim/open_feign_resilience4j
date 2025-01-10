package com.example.demo.client;

import com.example.demo.dto.LoginRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CircuitBreaker(name = "testCircuitBreaker")
@FeignClient(value = "members", url = "http://localhost:8080/members/")
public interface TestFeignClient {

    @PostMapping("/login")
    String login(@RequestBody LoginRequest request);

    @PostMapping("/logout")
    String logout(@RequestBody LoginRequest request);

    @PostMapping("/admin/login")
    String adminLogin(@RequestBody LoginRequest request);
}
