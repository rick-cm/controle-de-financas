package rcmto.financialregisterapi.repository

import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import rcmto.financialregisterapi.entity.Expense
import java.util.*

@EnableScan
interface ExpenseRepository : CrudRepository<Expense,String> {
    fun findByReferenceDateAndUser(referenceDate: String?, user: String?): Optional<Set<Expense>>
}