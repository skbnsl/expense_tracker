package net.javaguides.expense.controller;

import net.javaguides.expense.dto.ExpenseDto;
import net.javaguides.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto savedExpenseDto = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpenseDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId){
        ExpenseDto expenseDto = expenseService.getExpenseById(expenseId);
        return new ResponseEntity<>(expenseDto,HttpStatus.OK);
    }

}
