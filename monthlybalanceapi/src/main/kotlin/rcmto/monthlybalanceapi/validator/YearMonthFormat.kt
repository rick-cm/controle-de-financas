package rcmto.monthlybalanceapi.validator

import rcmto.monthlybalanceapi.validator.impl.YearMonthFormatValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [YearMonthFormatValidator::class])
@MustBeDocumented
annotation class YearMonthFormat(
    val message: String = "O valor da data é inválido",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = [],
)