package com.ems.expense_service.controller;

import com.ems.expense_service.dto.ExpenseDto;
import com.ems.expense_service.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping("")
    public ResponseEntity<List<ExpenseDto>> getExpenses(){
         List<ExpenseDto> response = expenseService.getAllExpenses();
         return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<ExpenseDto> addExpense(@RequestBody ExpenseDto dto){
        ExpenseDto response = expenseService.addExpense(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
