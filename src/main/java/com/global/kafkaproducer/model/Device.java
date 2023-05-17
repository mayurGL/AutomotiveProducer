package com.global.kafkaproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private int deviceId;
    private String deviceType;
    private String deviceName;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
    private String createdBy;
    private String modifiedBy;
}