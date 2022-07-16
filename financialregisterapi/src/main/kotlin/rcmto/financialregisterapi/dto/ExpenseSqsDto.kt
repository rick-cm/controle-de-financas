package rcmto.financialregisterapi.dto

import rcmto.financialregisterapi.enums.ExpenseType
import java.io.Serializable
import java.math.BigDecimal

data class ExpenseSqsDto (
    val type: ExpenseType,
    val amount: BigDecimal,
    var newAmount: BigDecimal,
    val referenceDate: String,
    val user: String
) : Serializable