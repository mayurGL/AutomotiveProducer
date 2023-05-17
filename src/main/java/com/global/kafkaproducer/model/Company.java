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
public class Company {
    private int companyId;
    private String companyName;
    private String companyAddress;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
    private String createdBy;
    private String modifiedBy;
}