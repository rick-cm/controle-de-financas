package rcmto.financialregisterapi.service

import org.springframework.stereotype.Service
import rcmto.financialregisterapi.entity.Income
import java.util.*

@Service
class IncomeService {
    fun addIncome(income: Income) : Optional<Income> {
        println(income);
        return Optional.empty();
    }
}