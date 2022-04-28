package rcmto.financialregisterapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/expenses")
class ExpenseController {

    @GetMapping
    fun addExpense() : ResponseEntity<Any> {
//        println(user.username)
        return ResponseEntity.ok().build();
    }
}