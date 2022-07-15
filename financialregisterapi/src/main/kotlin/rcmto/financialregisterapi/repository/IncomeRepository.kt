package rcmto.financialregisterapi.repository

import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import rcmto.financialregisterapi.entity.Income
import java.util.*

@EnableScan
interface IncomeRepository : CrudRepository<Income,String>{
    fun findByReferenceDateAndUser(referenceDate: String?, user: String?): Optional<Set<Income>>
}