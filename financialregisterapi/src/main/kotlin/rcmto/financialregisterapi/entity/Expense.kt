package rcmto.financialregisterapi.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum
import com.fasterxml.jackson.annotation.JsonProperty
import rcmto.financialregisterapi.enums.ExpenseStatus
import rcmto.financialregisterapi.enums.ExpenseType
import java.math.BigDecimal

@DynamoDBTable(tableName = "expenses")
data class Expense(
    @field:DynamoDBHashKey(attributeName = "uuid")
    private var uuid: String,
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

}