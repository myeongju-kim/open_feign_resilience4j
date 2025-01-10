package com.example.demo.dto;

import lombok.Getter;

@Getter
public class CommonResponse<T> {

    private final int code;
    private final String message;
    private final T data;

    private CommonResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(200, "success", data);
    }

    public static <T> CommonResponse<T> fail(int code, String message) {
        return new CommonResponse<>(code, message, null);
    }
}
