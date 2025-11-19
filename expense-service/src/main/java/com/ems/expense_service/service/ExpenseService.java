package com.ems.expense_service.service;

import com.ems.expense_service.dto.ExpenseDto;
import com.ems.expense_service.entity.Expense;
import com.ems.expense_service.repository.ExpenseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<ExpenseDto> getAllExpenses(){
        List<Expense> response =  expenseRepository.findAll();

         response.stream().map(entity->{
             ExpenseDto dto = new ExpenseDto();
             dto.setId(entity.getId());
             dto.setAmount(entity.getAmount());
             dto.setCategory(entity.getCategory());
             dto.setUserId(entity.getUserId());
             dto.setCreatedAt(entity.getCreatedAt());
             return dto;
        });
    }

    public ExpenseDto addExpense(ExpenseDto dto){
        Expense expense = new Expense();

        expense.setId(dto.getId());
        expense.setAmount(dto.getAmount());
        expense.setCategory(dto.getCategory());
        expense.setUserId(dto.getUserId());
        expense.setCreatedAt(dto.getCreatedAt());

        expenseRepository.save(expense);
        return dto;
    }
}
