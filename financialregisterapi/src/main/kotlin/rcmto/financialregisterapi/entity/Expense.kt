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
    @field:DynamoDBHashKey(attributeName = "uuid")
    private val uuid: String,
    @field:DynamoDBAttribute(attributeName = "user")
    private val user: String,
    @field:DynamoDBAttribute(attributeName = "amount")
    private val amount: BigDecimal,
    @field:DynamoDBAttribute(attributeName = "description")
    private val description: String,
    @JsonProperty("reference_date")
    @field:DynamoDBAttribute(attributeName = "reference_date")
    private val referenceDate: String,
    @field:DynamoDBAttribute(attributeName = "recurrent")
    private val recurrent: Boolean,
    @field:DynamoDBTypeConvertedEnum
    @field:DynamoDBAttribute(attributeName = "type")
    private val type: ExpenseType,
    @field:DynamoDBTypeConvertedEnum
    @field:DynamoDBAttribute(attributeName = "status")
    private val status: ExpenseStatus,
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