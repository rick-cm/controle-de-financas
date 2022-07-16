package rcmto.financialregisterapi.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum
import com.fasterxml.jackson.annotation.JsonProperty
import rcmto.financialregisterapi.dto.ExpenseSqsDto
import rcmto.financialregisterapi.enums.ExpenseStatus
import rcmto.financialregisterapi.enums.ExpenseType
import java.math.BigDecimal
import java.util.*

@DynamoDBTable(tableName = "expenses")
class Expense {
    @DynamoDBHashKey(attributeName = "uuid")
    var uuid: String = "";

    @DynamoDBAttribute(attributeName = "user")
    var user: String = "";
    @DynamoDBAttribute(attributeName = "amount")
    var amount: BigDecimal = BigDecimal.ZERO;
    @DynamoDBAttribute(attributeName = "description")
    var description: String = ""
    @JsonProperty("reference_date")
    @DynamoDBAttribute(attributeName = "reference_date")
    var referenceDate: String = ""
    @DynamoDBAttribute(attributeName = "recurrent")
    var recurrent: Boolean = false
    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "type")
    var type: ExpenseType = ExpenseType.OTHER
    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "status")
    var status: ExpenseStatus = ExpenseStatus.PENDING

    constructor()

    constructor(    uuid: String,
                    user: String,
                    amount: BigDecimal,
                    description: String,
                    referenceDate: String,
                    recurrent: Boolean,
                    type: ExpenseType,
                    status: ExpenseStatus
    ){
        this.uuid = uuid;
        this.user = user;
        this.amount = amount
        this.description = description
        this.referenceDate = referenceDate
        this.recurrent = recurrent
        this.type = type
        this.status = status
    }

    constructor(    user: String,
                    amount: BigDecimal,
                    description: String,
                    referenceDate: String,
                    recurrent: Boolean,
                    type: ExpenseType,
                    status: ExpenseStatus
    ) : this(UUID.randomUUID().toString(),user,amount,description,referenceDate,recurrent,type,status){
    }

    override fun toString(): String {
        return "$uuid $user $amount $description $referenceDate $recurrent $type $status"
    }

    fun toSqsMessage(): ExpenseSqsDto {
        return ExpenseSqsDto(
            type,
            amount,
            amount,
            referenceDate,
            user
        )
    }
}