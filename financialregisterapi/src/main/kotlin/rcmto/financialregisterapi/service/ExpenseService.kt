package rcmto.financialregisterapi.service

import org.springframework.stereotype.Service
import rcmto.financialregisterapi.entity.Expense
import java.util.*

@Service
class ExpenseService(){

    fun addExpense(expense: Expense) : Optional<Expense> {
        println(expense);
        return Optional.empty();
    }
}