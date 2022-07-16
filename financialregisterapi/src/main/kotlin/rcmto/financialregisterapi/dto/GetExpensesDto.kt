package rcmto.financialregisterapi.dto

import java.io.Serializable
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class GetExpensesDto : Serializable {
    @field:NotNull
    @field:NotBlank
    var user: String = ""

    constructor()

    constructor(user: String){
        this.user = user
    }
}