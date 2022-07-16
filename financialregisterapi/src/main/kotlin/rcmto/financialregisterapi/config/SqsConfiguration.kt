package rcmto.financialregisterapi.config

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import io.awspring.cloud.messaging.core.QueueMessagingTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SqsConfiguration {

    @Value("\${aws.sqs.endpointUrl}")
    private val endpointUrl: String? = null

    @Value("\${aws.region}")
    private val region: String? = null

    @Bean
    fun queueMessagingTemplate(
        amazonSQSAsync: AmazonSQSAsync
    ): QueueMessagingTemplate {
        return QueueMessagingTemplate(amazonSQSAsync)
    }

    @Bean
    fun amazonSQS(): AmazonSQSAsync {
        val amazonSQSAsync = AmazonSQSAsyncClientBuilder.standard()
            .withCredentials(DefaultAWSCredentialsProviderChain())
            .withEndpointConfiguration(EndpointConfiguration(endpointUrl, region))
            .build()

        amazonSQSAsync.createQueue("new-expense-queue")
        return amazonSQSAsync
    }
}