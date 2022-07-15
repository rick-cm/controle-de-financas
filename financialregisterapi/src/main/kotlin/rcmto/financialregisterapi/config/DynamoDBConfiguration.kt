package rcmto.financialregisterapi.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import org.slf4j.LoggerFactory
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableDynamoDBRepositories(basePackages = ["rcmto.financialregisterapi.repository"])
class DynamoDBConfiguration {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Value("\${aws.region}")
    private val region: String? = null

    @Value("\${aws.dynamodb.endpointUrl}")
    private val endpointUrl: String? = null

    @Value("\${aws.key}")
    private val key: String? = null

    @Value("\${aws.secret}")
    private val secret: String? = null

    fun amazonAWSCredentialsProvider(): AWSCredentialsProvider {
        return AWSStaticCredentialsProvider(amazonAWSCredentials())
    }

    @Bean
    fun amazonAWSCredentials(): AWSCredentials {
        return BasicAWSCredentials(key, secret)
    }

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder
            .standard()
            .withCredentials(amazonAWSCredentialsProvider())
            .withEndpointConfiguration(EndpointConfiguration(endpointUrl, region))
            .build()
    }

    @Bean
    fun dynamoDB(): DynamoDB {
        return DynamoDB(amazonDynamoDB())
    }
}