package net.javaguides.expense.service.impl;

import net.javaguides.expense.dto.ExpenseDto;
import net.javaguides.expense.entity.Category;
import net.javaguides.expense.entity.Expense;
import net.javaguides.expense.mapper.ExpenseMapper;
import net.javaguides.expense.repository.CategoryRepository;
import net.javaguides.expense.repository.ExpenseRepository;
import net.javaguides.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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
        return expenses.stream().map((expense)->ExpenseMapper.mapToExpenseDto(expense)).collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(()->new RuntimeException("Expense not found with given id "+expenseId));

        //update the expense
        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expensedate());

        if(expenseDto.categoryDto() != null){
            Category category = categoryRepository.findById(expenseDto.categoryDto().id()).orElseThrow(()->new RuntimeException("category not found with given id expense-categoryId "+expenseDto.categoryDto().id()));
            expense.setCategory(category);
        }

        Expense updatedExpense = expenseRepository.save(expense);

        return ExpenseMapper.mapToExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(()->new RuntimeException("Expense not found with given id "+expenseId));
        expenseRepository.delete(expense);
    }
}
