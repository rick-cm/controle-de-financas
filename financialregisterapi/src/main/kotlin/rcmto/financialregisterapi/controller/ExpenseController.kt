package rcmto.financialregisterapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import rcmto.financialregisterapi.dto.ExpenseRegisterDTO
import javax.validation.Valid

@RestController
@RequestMapping("/expenses")
class ExpenseController {

    @PostMapping
    @Transactional
    fun addExpense(@Valid @RequestBody request: ExpenseRegisterDTO) : ResponseEntity<Any> {
        println(request);
        return ResponseEntity.ok().build();
    }
}