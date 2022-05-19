package rcmto.financialregisterapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import rcmto.financialregisterapi.dto.ExpenseRegisterDTO
import rcmto.financialregisterapi.service.ExpenseService
import javax.validation.Valid

@RestController
@RequestMapping("/expenses")
class ExpenseController(val service : ExpenseService) {

    @PostMapping
    @Transactional
    fun addExpense(@Valid @RequestBody request: ExpenseRegisterDTO) : ResponseEntity<Any> {
        service.addExpense(request.toExpense())
        return ResponseEntity.ok().build();
    }
}