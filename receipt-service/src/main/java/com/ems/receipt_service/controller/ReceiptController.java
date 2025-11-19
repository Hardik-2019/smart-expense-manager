package com.ems.receipt_service.controller;

import com.ems.receipt_service.dto.ReceiptDto;
import com.ems.receipt_service.entity.Receipt;
import com.ems.receipt_service.service.ReceiptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService){
        this.receiptService = receiptService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ReceiptDto> addReceipt(@RequestBody ReceiptDto dto){
        ReceiptDto response = receiptService.uploadReceipt(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceiptDto> gerReceipt(@RequestParam Long id){
        ReceiptDto response = receiptService.findReceiptById(id);
        return ResponseEntity.ok(response);
    }
}
