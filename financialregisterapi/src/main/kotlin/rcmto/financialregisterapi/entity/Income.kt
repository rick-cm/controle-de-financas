package rcmto.financialregisterapi.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum
import com.fasterxml.jackson.annotation.JsonProperty
import rcmto.financialregisterapi.enums.IncomeStatus
import rcmto.financialregisterapi.enums.IncomeType
import java.math.BigDecimal
import java.util.*

@DynamoDBTable(tableName = "incomes")
class Income {
    @DynamoDBHashKey(attributeName = "uuid")
    var uuid: String = ""
    @DynamoDBAttribute(attributeName = "user")
    var user: String = ""
    @DynamoDBAttribute(attributeName = "amount")
    var amount: BigDecimal = BigDecimal.ZERO
    @DynamoDBAttribute(attributeName = "description")
    var description: String = ""
    @JsonProperty("reference_date")
    @DynamoDBAttribute(attributeName = "reference_date")
    var referenceDate: String = ""
    @DynamoDBAttribute(attributeName = "recurrent")
    var recurrent: Boolean = false
    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "type")
    var type: IncomeType = IncomeType.OTHER
    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "status")
    var status: IncomeStatus = IncomeStatus.PENDING

    constructor()

    constructor(uuid: String,
                user: String,
                amount: BigDecimal,
                description: String,
                referenceDate: String,
                recurrent: Boolean,
                type: IncomeType,
                status: IncomeStatus
    ) {
        this.uuid = uuid;
        this.user = user;
        this.amount = amount
        this.description = description
        this.referenceDate = referenceDate
        this.recurrent = recurrent
        this.type = type
        this.status = status
    }

    constructor(user: String,
                amount: BigDecimal,
                description: String,
                referenceDate: String,
                recurrent: Boolean,
                type: IncomeType,
                status: IncomeStatus
    ) : this(UUID.randomUUID().toString(),user,amount,description,referenceDate,recurrent,type,status)
}