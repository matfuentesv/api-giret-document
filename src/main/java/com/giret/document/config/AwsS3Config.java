package com.giret.document.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class AwsS3Config {



    @Bean
    public S3Client s3Client() {
        AwsSessionCredentials sessionCredentials = AwsSessionCredentials.create(
                "ASIAUIIHPI6S2B5YMWZX",
                "GitBxdWvgBWq8iLNsEqdbDK7aK+CcXbhWUa5vboW",
                "IQoJb3JpZ2luX2VjEHgaCXVzLXdlc3QtMiJIMEYCIQC9JPK9gUJddAr3mGYULtVN9vOzioMM+y/6KcnSwvVohQIhAP8F89j9xYHSWoXXP/MccSXvRgbXdOasDJbycyIKSzXfKroCCIH//////////wEQARoMMjkyNjEwMzI4NDg1Igxv+mooPno+KRcDKdcqjgJJB/PuZWgxDcafdC1j4il/vmY6EC7La9NXIUGK2Zg5NJ7qPxxTfYNuLAejlstQVeiwL+p2OqVcAmRtMPJoTQg4xxrbbdREdtk2UR2iXc8u0A55C8yVdVdBwy8cyTXlnr8CliZJ1R4zXOvuuWz9gkz22jxbK5H1vaONqmof4i33KU6/vTGnQUCCsTzVnRzEadkwn2T8I9Ks3dRevEDutA3RoI3VpfLfYx1d8sncS5ACInLoHzu1n77KFNBxoLOLY9yEaTI6udH7hysdnEBGe3rlnYnQKhLnUITtB4DejVfGR2n8iu8X8D19rsRdLuaGPlEzHhaAb9nFFcFG91qyzOsnVdHM9PXUHnoku+LfAOow4rGxwwY6nAGTY7yQQr5sT9/pIwHL60ivgQTzP5VGDF3Vv7t0nG93NwFjp6VtNkP1OdgFeKZErR78SYfOYsmb6CrLeWer4IP/AwkxPHpYa4rR8qy15mHxPU+vvSAox/WkddcM4atOXah2H7pyvIyo5wLmEV5Hf5smxQJvwgf+8xO4xTkX08Ua3CLaB1ScsZZaitgaqeu2XCF6b9ZgXeXwTZXKb68="
        );

        return S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .build();
    }

    @Bean
    public S3Presigner s3Presigner() {
        AwsSessionCredentials sessionCredentials = AwsSessionCredentials.create(
                "ASIAUIIHPI6S2B5YMWZX",
                "GitBxdWvgBWq8iLNsEqdbDK7aK+CcXbhWUa5vboW",
                "IQoJb3JpZ2luX2VjEHgaCXVzLXdlc3QtMiJIMEYCIQC9JPK9gUJddAr3mGYULtVN9vOzioMM+y/6KcnSwvVohQIhAP8F89j9xYHSWoXXP/MccSXvRgbXdOasDJbycyIKSzXfKroCCIH//////////wEQARoMMjkyNjEwMzI4NDg1Igxv+mooPno+KRcDKdcqjgJJB/PuZWgxDcafdC1j4il/vmY6EC7La9NXIUGK2Zg5NJ7qPxxTfYNuLAejlstQVeiwL+p2OqVcAmRtMPJoTQg4xxrbbdREdtk2UR2iXc8u0A55C8yVdVdBwy8cyTXlnr8CliZJ1R4zXOvuuWz9gkz22jxbK5H1vaONqmof4i33KU6/vTGnQUCCsTzVnRzEadkwn2T8I9Ks3dRevEDutA3RoI3VpfLfYx1d8sncS5ACInLoHzu1n77KFNBxoLOLY9yEaTI6udH7hysdnEBGe3rlnYnQKhLnUITtB4DejVfGR2n8iu8X8D19rsRdLuaGPlEzHhaAb9nFFcFG91qyzOsnVdHM9PXUHnoku+LfAOow4rGxwwY6nAGTY7yQQr5sT9/pIwHL60ivgQTzP5VGDF3Vv7t0nG93NwFjp6VtNkP1OdgFeKZErR78SYfOYsmb6CrLeWer4IP/AwkxPHpYa4rR8qy15mHxPU+vvSAox/WkddcM4atOXah2H7pyvIyo5wLmEV5Hf5smxQJvwgf+8xO4xTkX08Ua3CLaB1ScsZZaitgaqeu2XCF6b9ZgXeXwTZXKb68="
        );

        return S3Presigner.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .build();
    }
}
