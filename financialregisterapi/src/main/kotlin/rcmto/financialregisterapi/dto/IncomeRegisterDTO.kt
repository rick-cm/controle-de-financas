package rcmto.financialregisterapi.dto

import com.fasterxml.jackson.annotation.JsonProperty
import rcmto.financialregisterapi.entity.Income
import rcmto.financialregisterapi.enums.IncomeStatus
import rcmto.financialregisterapi.enums.IncomeType
import rcmto.financialregisterapi.validator.YearMonthFormat
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class IncomeRegisterDTO (
    @field:NotNull
    @field:Positive
    private var amount: BigDecimal,
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
    private val type: IncomeType,
    @field:NotNull
    private val status: IncomeStatus,
){
    fun toIncome(user: String): Income {
        return Income(
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