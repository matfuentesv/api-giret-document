package com.giret.document.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsS3Config {

    @Bean
    public S3Client s3Client() {
        AwsSessionCredentials sessionCredentials = AwsSessionCredentials.create(
                "ASIAUIIHPI6SX5A5N67R",
                "g7YRqZioTKGNwLKqR8uY+fhfH7A5fr2qY32s/ICZ",
                "IQoJb3JpZ2luX2VjEAIaCXVzLXdlc3QtMiJIMEYCIQD+cXdC6bfk9/W16hUndx/YC3vCmFCjm9nN+g6n0j/F8QIhAPCiDDBD0WZdbbaVl/Lj2B2NEbbL5fg9f5geWPcy0ACRKroCCPv//////////wEQARoMMjkyNjEwMzI4NDg1IgyCDWkpC4UjRoOJ2wAqjgJ+pZDCs1UFComqFCiGAkstqIxr/DdZHH5XYlqqUFXZKctz3kD5JGirQBio5L/cpI+bfEI5i9ArLkQ3SJaPZVLlWFETlvIQbmufeKe103Eu4tdZd0oIeUol/+jq/l6mEVn93YYzC6eapYVLk4xhst6B9qrRzl5ctl6G4WkdpDzOo+rr67TGzfFT0tbNIVvgiwCN5/22Td51UH8QsUM9PdfDCTWM482zqUragkzjtQhQAj+7eljZpU4tJDkL1+IK6QesQRV3x7lQphtbmuf4o+4m9OLchxHxNkcNPIrlR19bfuP0BS1tC4Q5i7g5xMDYI5vP+8SknpD07nr3mVpdYPpYFod+x/vSTx0boWkHNnAwq8CXwwY6nAGZYPhA6aWyCU430/CplPSNLWAUaZy2hIgP8mQCQT8afJMQuFQCpRgXKC2nZRm5+55+tDFcHywOkAvufvYJziXKPIrnsaak5ImnGFKXP5FrFBdyK3ZDAeSbtSW41oQRFwvsX+nY5c2O0iWRx+J5/g/w7CoKcPDLNBfrZQR9sETPrQ3wjnRnSkUHNTElZxwxt+cjYBFHqi/Vu0Gj9hk="
        );

        return S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .build();
    }
}
