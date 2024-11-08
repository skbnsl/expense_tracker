package net.javaguides.expense.service.impl;

import net.javaguides.expense.dto.ExpenseDto;
import net.javaguides.expense.entity.Expense;
import net.javaguides.expense.mapper.ExpenseMapper;
import net.javaguides.expense.repository.ExpenseRepository;
import net.javaguides.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        //convert expenseDto to expense entity
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);
        Expense savedExpense = expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(()-> new RuntimeException("Expense Not found with given id "+expenseId));
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();

    }
}
