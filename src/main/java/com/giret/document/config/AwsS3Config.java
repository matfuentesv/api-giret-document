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
                "ASIAUIIHPI6SSBUSGXHR",
                "RZgYbmCOO1xPLZ21KvQ72zHGnGNc5Sx/yqUiL0Ev",
                "IQoJb3JpZ2luX2VjEAUaCXVzLXdlc3QtMiJGMEQCIHu7sJBrwfUvt9ngEGz9uebXqZ5/JeF5sXJ8uHWQPxyWAiBzd3csmtu/uzHD/hgnPXO4fHgtdihyNhIg/fdfBHSnxiqxAggeEAEaDDI5MjYxMDMyODQ4NSIMm7FS9pavxQafaKRIKo4C/u7ANguRLG1SFtm0muhErP9OCnfotYEK2hVQ0ZucGWSsWOcJ55OeweErzoQXVv2ItxhzB/ayiWqDtEMOvCOPFIeFhrUw/ijUuopB8n2ur+04LIm4Vobk4ynbNXlzks9asvcyPOQOhD4Xm2JGjrVnNphT2SHbvLm1LQu839kp8A8Lx7F+K5Cvxp31fNH4D0pHv3NlBuqg0xvH1mGJrACdJUTOn/plYW/EsiWAAcHKducW6CMawGz3MpAN3kS2pt4sQ7XSVJFKVBIwiHdLYFRD4nPsoLJnRRcu/9X2Kdmzs4wIH5Mb+NE1Y/fZPyoRLiW36Vwe1EkC72MaQsibs3Qe2eWChi71qDlrliKqezJNMOSq0MMGOp4BziLP1XDVDITYxAIChlF78wNfefYVqP6neu9zJfOo+oI40LsAxMQF6JhBwlEzVrKxP71kRwgqt7VH6RGYXrpNKtp3KfoXthOmtWkvVqNJCpgHlrNc/rsp123zM8BWICD0Xu+qiAB1rw5YnyAjTpE2TcZ4X+2V0pTrQmeyaMaMaToI+ESqvItpRQbglcGchuW1nm+d/UzFzmXefrrLwxU="
        );

        return S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .build();
    }

    @Bean
    public S3Presigner s3Presigner() {
        AwsSessionCredentials sessionCredentials = AwsSessionCredentials.create(
                "ASIAUIIHPI6SSBUSGXHR",
                "RZgYbmCOO1xPLZ21KvQ72zHGnGNc5Sx/yqUiL0Ev",
                "IQoJb3JpZ2luX2VjEAUaCXVzLXdlc3QtMiJGMEQCIHu7sJBrwfUvt9ngEGz9uebXqZ5/JeF5sXJ8uHWQPxyWAiBzd3csmtu/uzHD/hgnPXO4fHgtdihyNhIg/fdfBHSnxiqxAggeEAEaDDI5MjYxMDMyODQ4NSIMm7FS9pavxQafaKRIKo4C/u7ANguRLG1SFtm0muhErP9OCnfotYEK2hVQ0ZucGWSsWOcJ55OeweErzoQXVv2ItxhzB/ayiWqDtEMOvCOPFIeFhrUw/ijUuopB8n2ur+04LIm4Vobk4ynbNXlzks9asvcyPOQOhD4Xm2JGjrVnNphT2SHbvLm1LQu839kp8A8Lx7F+K5Cvxp31fNH4D0pHv3NlBuqg0xvH1mGJrACdJUTOn/plYW/EsiWAAcHKducW6CMawGz3MpAN3kS2pt4sQ7XSVJFKVBIwiHdLYFRD4nPsoLJnRRcu/9X2Kdmzs4wIH5Mb+NE1Y/fZPyoRLiW36Vwe1EkC72MaQsibs3Qe2eWChi71qDlrliKqezJNMOSq0MMGOp4BziLP1XDVDITYxAIChlF78wNfefYVqP6neu9zJfOo+oI40LsAxMQF6JhBwlEzVrKxP71kRwgqt7VH6RGYXrpNKtp3KfoXthOmtWkvVqNJCpgHlrNc/rsp123zM8BWICD0Xu+qiAB1rw5YnyAjTpE2TcZ4X+2V0pTrQmeyaMaMaToI+ESqvItpRQbglcGchuW1nm+d/UzFzmXefrrLwxU="
        );

        return S3Presigner.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .build();
    }
}
