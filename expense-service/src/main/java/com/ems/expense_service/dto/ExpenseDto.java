package com.ems.expense_service.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ExpenseDto {
    private Long id;
    private Long userId;
    private Integer amount;
    private String category;
    private LocalDate createdAt;
}
