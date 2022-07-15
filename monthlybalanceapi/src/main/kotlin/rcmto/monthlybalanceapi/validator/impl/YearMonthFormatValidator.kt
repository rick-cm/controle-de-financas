package rcmto.monthlybalanceapi.validator.impl

import rcmto.monthlybalanceapi.validator.YearMonthFormat
import java.time.YearMonth
import java.time.format.DateTimeParseException
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class YearMonthFormatValidator : ConstraintValidator<YearMonthFormat, String>  {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return if (value == null || value.isBlank()) {
            true
        } else try {
            YearMonth.parse(value)
            true
        } catch (e: DateTimeParseException) {
            false
        }
    }
}