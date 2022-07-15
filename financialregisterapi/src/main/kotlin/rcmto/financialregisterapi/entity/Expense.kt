package rcmto.financialregisterapi.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum
import com.fasterxml.jackson.annotation.JsonProperty
import rcmto.financialregisterapi.enums.ExpenseStatus
import rcmto.financialregisterapi.enums.ExpenseType
import java.math.BigDecimal
import java.util.*

@DynamoDBTable(tableName = "expenses")
data class Expense(
    @DynamoDBHashKey(attributeName = "uuid")
    val uuid: String,
    @DynamoDBAttribute(attributeName = "user")
    val user: String,
    @DynamoDBAttribute(attributeName = "amount")
    val amount: BigDecimal,
    @DynamoDBAttribute(attributeName = "description")
    val description: String,
    @JsonProperty("reference_date")
    @DynamoDBAttribute(attributeName = "reference_date")
    val referenceDate: String,
    @DynamoDBAttribute(attributeName = "recurrent")
    val recurrent: Boolean,
    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "type")
    val type: ExpenseType,
    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "status")
    val status: ExpenseStatus,
){
    constructor(    user: String,
                    amount: BigDecimal,
                    description: String,
                    referenceDate: String,
                    recurrent: Boolean,
                    type: ExpenseType,
                    status: ExpenseStatus
    ) : this(UUID.randomUUID().toString(),user,amount,description,referenceDate,recurrent,type,status){
    }
}