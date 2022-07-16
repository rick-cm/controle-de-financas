package rcmto.financialregisterapi.dto

import rcmto.financialregisterapi.enums.FinancialRegisterType
import java.io.Serializable
import java.math.BigDecimal

data class SqsMessageDto (
    val type: FinancialRegisterType,
    val amount: BigDecimal,
    var newAmount: BigDecimal,
    val referenceDate: String,
    val user: String
) : Serializable