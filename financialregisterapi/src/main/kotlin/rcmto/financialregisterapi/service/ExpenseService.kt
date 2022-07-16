package rcmto.financialregisterapi.service

import io.awspring.cloud.messaging.core.QueueMessagingTemplate
import org.springframework.stereotype.Service
import rcmto.financialregisterapi.entity.Expense
import rcmto.financialregisterapi.repository.ExpenseRepository
import java.util.*

@Service
class ExpenseService(private val repository: ExpenseRepository,
                     private val messagingTemplate: QueueMessagingTemplate
){

    fun addExpense(expense: Expense) : Optional<Expense> {
        println(expense);
        messagingTemplate.convertAndSend("new-financial-register-queue", expense.toSqsMessage())
        return Optional.of(repository.save(expense));
    }

    fun getExpenseByReferenceDate(referenceDate: String, user: String) : Optional<Set<Expense>> {
        return repository.findByReferenceDateAndUser(referenceDate, user)
    }
}