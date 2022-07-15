package rcmto.financialregisterapi.dto

import com.fasterxml.jackson.annotation.JsonProperty
import rcmto.financialregisterapi.entity.Expense
import rcmto.financialregisterapi.enums.ExpenseStatus
import rcmto.financialregisterapi.enums.ExpenseType
import rcmto.financialregisterapi.validator.YearMonthFormat
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class ExpenseRegisterDTO(
    @field:NotNull
    @field:Positive
    private var amount:  BigDecimal,
    @field:NotNull
    @field:NotBlank
    private val description: String,
    @JsonProperty("reference_date")
    @YearMonthFormat
    @field:NotNull
    private val referenceDate:  String,
    @field:NotNull
    private var recurrent: Boolean,
    @field:NotNull
    private val type: ExpenseType,
    @field:NotNull
    private val status: ExpenseStatus,
) {
    fun toExpense(user: String): Expense{
        return Expense(
            user,
            amount,
            description,
            referenceDate,
            recurrent,
            type,
            status,
        )
    }
}