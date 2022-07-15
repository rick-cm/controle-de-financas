package rcmto.financialregisterapi.repository

import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import rcmto.financialregisterapi.entity.Expense

@EnableScan
interface ExpenseRepository : CrudRepository<Expense,String> {
}