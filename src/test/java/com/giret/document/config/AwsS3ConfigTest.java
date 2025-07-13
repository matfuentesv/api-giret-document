package com.giret.document.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

import static org.assertj.core.api.Assertions.assertThat;


@Configuration
public class AwsS3ConfigTest {

    private final AwsS3Config awsS3Config = new AwsS3Config();

    @Test
    void shouldCreateS3Client() {
        S3Client s3Client = awsS3Config.s3Client();

        assertThat(s3Client).isNotNull();
        assertThat(s3Client.serviceName()).isEqualTo("s3");
    }

    @Test
    void shouldCreateS3Presigner() {
        S3Presigner s3Presigner = awsS3Config.s3Presigner();

        assertThat(s3Presigner).isNotNull();
    }

}

