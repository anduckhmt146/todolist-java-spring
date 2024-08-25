package com.zalopay.todolist.dto;

public class ApiResponse<T> {

    private int code;
    private T data;
    private String error;

    public ApiResponse() {
    }

    public ApiResponse(int code, T data, String error) {
        this.code = code;
        this.data = data;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
