package rcmto.monthlybalanceapi.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import java.math.BigDecimal
import java.util.*

@DynamoDBTable(tableName = "monthly-balance")
data class MonthlyBalance(
    @field:DynamoDBHashKey(attributeName = "uuid")
    private val uuid: String,
    @field:DynamoDBAttribute(attributeName = "user")
    private val user: String,
    @field:DynamoDBAttribute(attributeName = "reference_date")
    private val referenceDate: String,
    @field:DynamoDBAttribute(attributeName = "income_amount")
    private val incomeAmount: BigDecimal,
    @field:DynamoDBAttribute(attributeName = "expense_amount")
    private val expenseAmount: BigDecimal,
    @field:DynamoDBAttribute(attributeName = "balance")
    private val balance: BigDecimal,
) {
    constructor(
        user: String,
        referenceDate: String
    ) : this(UUID.randomUUID().toString(), user, referenceDate, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO)
}