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
public class Gps {


    private LocalDateTime createdTime;


    private String vehicleId;


    private String deviceId;


    private String companyId;


    private double latitude;


    private double longitude;


    private double speed;
}

