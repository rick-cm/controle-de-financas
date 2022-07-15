package rcmto.monthlybalanceapi.dto

import java.math.BigDecimal

class MonthlyBalanceResponseDto (
    private val uuid: String,
    private val user: String,
    private val referenceDate: String,
    private val incomeAmount: BigDecimal,
    private val expenseAmount: BigDecimal,
    private val balance: BigDecimal,
) {
}