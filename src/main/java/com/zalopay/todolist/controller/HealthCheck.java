package com.zalopay.todolist.controller;

import com.zalopay.todolist.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheck {
    @RequestMapping
    public ApiResponse<HealthStatus> healthCheck() {
        return new ApiResponse<>(HttpStatus.OK.value(), new HealthStatus("OK"), null);
    }

    public static class HealthStatus {
        private String status;

        public HealthStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}