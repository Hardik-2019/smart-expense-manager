package com.ems.receipt_service.service;

import com.ems.receipt_service.dto.ReceiptDto;
import com.ems.receipt_service.entity.Receipt;
import com.ems.receipt_service.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReceiptService {

    private ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository){
        this.receiptRepository = receiptRepository;
    }

    public ReceiptDto uploadReceipt(ReceiptDto dto){
        Receipt entity = new Receipt();
        entity.setUploadedAt(dto.getUploadedAt());
        entity.setUserId(dto.getUserId());
        entity.setFileName(dto.getFileName());
        entity.setS3Url(dto.getS3Url());
        receiptRepository.save(entity);
        return dto;
    }

    public ReceiptDto findReceiptById(Long id){
        Receipt entity = receiptRepository.findById(id).orElseThrow(()-> new RuntimeException("Receipt not found"));
        ReceiptDto dto = new ReceiptDto();
        dto.setUploadedAt(entity.getUploadedAt());
        dto.setUserId(entity.getUserId());
        dto.setFileName(entity.getFileName());
        dto.setS3Url(entity.getS3Url());
        return dto;
    }
}
