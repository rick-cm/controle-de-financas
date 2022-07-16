package rcmto.monthlybalanceapi.service

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy
import io.awspring.cloud.messaging.listener.annotation.SqsListener
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Service

@Service
class MonthlyBalanceService {

    @SqsListener("new-financial-register-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    fun receiveMessage(message: String, @Header("MessageId") transactionId: String) {

        println(message)
    }
}