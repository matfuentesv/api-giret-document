package com.giret.document.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsS3Config {

    @Bean
    public S3Client s3Client() {
        AwsSessionCredentials sessionCredentials = AwsSessionCredentials.create(
                "ASIAUIIHPI6SRHO5VJ3A",
                "+O2j4ek9BFSTXtSVUCPn0QFlh6vqPaYjWf17EQHb",
                "IQoJb3JpZ2luX2VjENL//////////wEaCXVzLXdlc3QtMiJGMEQCIF1z012vCtm0r31VNh/lC9106SkLBnOCpdqna4CsACSHAiAQ84DGL/EQyFcpNyYxRDnq9KFCLhLEuQFH8Y8/t3oemyq6AgjL//////////8BEAEaDDI5MjYxMDMyODQ4NSIMX4WwclYKMIX8Bzf9Ko4CWc3G7lPvxBbS8+2ZnOgyebRGJduqxOw4Ex5/+GCkdiGNX9Dh/SzMUuqzwy0v1iS+DvlN7zCpNFwZvrpfG+wuR7Kt69BdHUmLjbz8BQjzhBp0/YfBonLi+Nna4gczVB1FzBejM1TsR88/pPK0yV+7jOOigrc6HmZHfoy9fPf8H6yJWtNCqFcQS6XyDL1SXAdPtn4aPLRyUt7OBtqD4KGh7yj5L9LJP/IyWlgmeJ8PwkYTMIxnMAVRoh6oitVqLEE/1SH3HI62tElTgc2iY8CeFuMIuOqjqN92KO4dwBYVljIkKu+FFMs8G5gRPmhLkcq2hekTERgCrouIlj5cb57nimGwtPY0qR56mBfFMg32MLuCjcMGOp4BNgkgZ2WcAGvSwJKSUk5mrr7luJMKVYHSiE2Ld1dOtWNE1Vy+fEQnCpFIcZsulvxoU3+dkKfQ1OgvAbseHd9vpVGZmUL2mnrHHldWynZr7HeXSpY9Po1T2OxbpFVcXlHhHlRqn0qqcqUNvGqGsk+c+Hv9/8DfnDJrdYF0DPwZfQn8E89khEBtAdvIL6/q00lW30PoMFQnjqqZ9P6Cy6c="
        );

        return S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .build();
    }
}
