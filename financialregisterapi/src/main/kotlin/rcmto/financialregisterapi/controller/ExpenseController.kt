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
        //TODO: pegar o user do autentication principal
        val user = "rick@email.com"
        service.addExpense(request.toExpense(user))
        return ResponseEntity.ok().build();
    }
}