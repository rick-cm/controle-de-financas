package rcmto.financialregisterapi.service

import org.springframework.stereotype.Service
import rcmto.financialregisterapi.entity.Expense
import rcmto.financialregisterapi.repository.ExpenseRepository
import java.util.*

@Service
class ExpenseService(private val repository: ExpenseRepository){

    fun addExpense(expense: Expense) : Optional<Expense> {
        println(expense);
        return Optional.of(repository.save(expense));
    }
}