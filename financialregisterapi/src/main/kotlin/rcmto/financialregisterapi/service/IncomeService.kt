package rcmto.financialregisterapi.service

import org.springframework.stereotype.Service
import rcmto.financialregisterapi.entity.Income
import rcmto.financialregisterapi.repository.IncomeRepository
import java.util.*

@Service
class IncomeService(private val repository: IncomeRepository) {
    fun addIncome(income: Income) : Optional<Income> {
        println(income);
        return Optional.of(repository.save(income));
    }
}