package rcmto.financialregisterapi.repository

import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import rcmto.financialregisterapi.entity.Income

@EnableScan
interface IncomeRepository : CrudRepository<Income,String>{
}