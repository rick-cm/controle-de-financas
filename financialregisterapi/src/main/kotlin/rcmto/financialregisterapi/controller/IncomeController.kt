package rcmto.financialregisterapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import rcmto.financialregisterapi.dto.IncomeRegisterDTO
import rcmto.financialregisterapi.entity.Expense
import rcmto.financialregisterapi.entity.Income
import rcmto.financialregisterapi.service.IncomeService
import javax.validation.Valid

@RestController
@RequestMapping("/incomes")
class IncomeController(val service : IncomeService) {

    @PostMapping
    @Transactional
    fun addIncome(@Valid @RequestBody request: IncomeRegisterDTO) : ResponseEntity<Any> {
        //TODO: pegar o user do autentication principal
        val user = "rick@email.com"
        val addIncome = service.addIncome(request.toIncome(user))
        return ResponseEntity.ok(addIncome.get())
    }

    @GetMapping
    fun getExpensesByReferenceDate(@RequestParam("reference_date") referenceDate: String) : ResponseEntity<Set<Income>> {
        //TODO: pegar o user do autentication principal
        val user = "rick@email.com"
        val incomesList = service.getincomesByReferenceDate(referenceDate, user)
        return ResponseEntity.ok(incomesList.get());
    }
}