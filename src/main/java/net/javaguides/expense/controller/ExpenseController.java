package net.javaguides.expense.controller;

import net.javaguides.expense.dto.ExpenseDto;
import net.javaguides.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        List<ExpenseDto> expenseDtos = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenseDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpenses(@PathVariable("id") Long expenseId, @RequestBody ExpenseDto expenseDto) {
        ExpenseDto updatedExpenseDto = expenseService.updateExpense(expenseId,expenseDto);
        return ResponseEntity.ok(updatedExpenseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("expense deleted successfully!!");
    }

}
