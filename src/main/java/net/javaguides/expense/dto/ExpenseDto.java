package net.javaguides.expense.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseDto(Long id,
                         BigDecimal amount,
                         LocalDate expensedate,
                         CategoryDto categoryDto) {
}
