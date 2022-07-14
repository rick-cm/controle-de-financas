package rcmto.financialregisterapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rcmto.financialregisterapi.dto.IncomeRegisterDTO
import rcmto.financialregisterapi.service.IncomeService
import javax.validation.Valid

@RestController
@RequestMapping("/incomes")
class IncomeController(val service : IncomeService) {

    @PostMapping
    @Transactional
    fun addIncome(@Valid @RequestBody request: IncomeRegisterDTO) : ResponseEntity<Any> {
        service.addIncome(request.toIncome())
        return ResponseEntity.ok().build();
    }
}