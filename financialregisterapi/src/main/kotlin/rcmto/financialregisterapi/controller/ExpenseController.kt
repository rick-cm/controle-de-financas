package rcmto.financialregisterapi.controller

import org.jetbrains.annotations.NotNull
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import rcmto.financialregisterapi.dto.ExpenseRegisterDTO
import rcmto.financialregisterapi.dto.GetExpensesDto
import rcmto.financialregisterapi.entity.Expense
import rcmto.financialregisterapi.service.ExpenseService
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/expenses")
class ExpenseController(val service : ExpenseService) {

    @PostMapping
    @Transactional
    fun addExpense(@Valid @RequestBody request: ExpenseRegisterDTO) : ResponseEntity<Expense> {
        //TODO: pegar o user do autentication principal
        val user = "rick@email.com"
        val addExpense = service.addExpense(request.toExpense(user))
        return ResponseEntity.ok(addExpense.get());
    }

    @GetMapping
    fun getExpensesByReferenceDate(@RequestParam("reference_date") referenceDate: String, @Valid @RequestBody dto: GetExpensesDto) : ResponseEntity<Set<Expense>> {
        //TODO: pegar o user do autentication principal
        val expenseList = service.getExpenseByReferenceDate(referenceDate, dto.user)
        return ResponseEntity.ok(expenseList.get());
    }
}