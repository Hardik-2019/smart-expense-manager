package com.ems.receipt_service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReceiptDto {
    private Long id;
    private Long userId;
    private String fileName;
    private String s3Url;
    private LocalDate uploadedAt;
}
