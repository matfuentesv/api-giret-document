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
                "ASIAUIIHPI6S7AWP4ZYD",
                "+GrQr6q/zSnFjqs4ogv8rKYwtWNh8CI4RV7l4WbV",
                "IQoJb3JpZ2luX2VjEP///////////wEaCXVzLXdlc3QtMiJHMEUCIQC+FB9sof9zmNb3dg9yFtH30zsg8Et34O4C5rBVb+uV+gIgAxy+3YXbq7jUkXklI0Mkshr6mn7AifHFr3BaGIVxfDMqsQIIGBABGgwyOTI2MTAzMjg0ODUiDAeXlv/aq06p5X0SZiqOAgcQ1ctiBTkqThY1wq25pzf4M/Yabm23c6QT/vQhCPOsD8+zTun12JiSIoStvGU5Ff3nKAAy+fH/ctBs7MavZKj4tV/3oweSCXqLSi9yJ+H7PR1rGn0qIqK/EB47WTl1v0mFlrvINrnzMyDUsf9FOHP0N3Afohn46C0UQYX5dSGcVhxYLRZv6es1kjoLaDM33g6eVd+MFHpCgBSSc1m80N8FfWwm49bd03F1n23Z0kmD2+rhLLAFQ8EAEMe2UTfohCKox1huM6v8bU8A5NRRN5RygXoVCzLD4cK/gAnRBYPeuhMd4TpIX8y+kEi0H2EYZxGAMrAcmuMvIS9q0IdOsMxXEijDVXk3r2ftOVSgijDFmM/DBjqdAfROY018ryGZ/VBJZ/DoL18bBdL1EsPXUycC0fDOhsS5A3QhTvVl3upU+tur8s4g34vYZE9aXQ4RyvHTDps2tu75wlJXae1hruiY/C6nmJNv4da05ZjUuMTGjdUt7xaUsbv14wbGYqSeUFsQ4svUvJNVSmndCcxlSXiMrUS5VOSrnhQ4lscO+X0vXoKbPdNi78rOEN5mNMv1NCNc0UQ="
        );

        return S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .build();
    }

    @Bean
    public S3Presigner s3Presigner() {
        AwsSessionCredentials sessionCredentials = AwsSessionCredentials.create(
                "ASIAUIIHPI6S7AWP4ZYD",
                "+GrQr6q/zSnFjqs4ogv8rKYwtWNh8CI4RV7l4WbV",
                "IQoJb3JpZ2luX2VjEP///////////wEaCXVzLXdlc3QtMiJHMEUCIQC+FB9sof9zmNb3dg9yFtH30zsg8Et34O4C5rBVb+uV+gIgAxy+3YXbq7jUkXklI0Mkshr6mn7AifHFr3BaGIVxfDMqsQIIGBABGgwyOTI2MTAzMjg0ODUiDAeXlv/aq06p5X0SZiqOAgcQ1ctiBTkqThY1wq25pzf4M/Yabm23c6QT/vQhCPOsD8+zTun12JiSIoStvGU5Ff3nKAAy+fH/ctBs7MavZKj4tV/3oweSCXqLSi9yJ+H7PR1rGn0qIqK/EB47WTl1v0mFlrvINrnzMyDUsf9FOHP0N3Afohn46C0UQYX5dSGcVhxYLRZv6es1kjoLaDM33g6eVd+MFHpCgBSSc1m80N8FfWwm49bd03F1n23Z0kmD2+rhLLAFQ8EAEMe2UTfohCKox1huM6v8bU8A5NRRN5RygXoVCzLD4cK/gAnRBYPeuhMd4TpIX8y+kEi0H2EYZxGAMrAcmuMvIS9q0IdOsMxXEijDVXk3r2ftOVSgijDFmM/DBjqdAfROY018ryGZ/VBJZ/DoL18bBdL1EsPXUycC0fDOhsS5A3QhTvVl3upU+tur8s4g34vYZE9aXQ4RyvHTDps2tu75wlJXae1hruiY/C6nmJNv4da05ZjUuMTGjdUt7xaUsbv14wbGYqSeUFsQ4svUvJNVSmndCcxlSXiMrUS5VOSrnhQ4lscO+X0vXoKbPdNi78rOEN5mNMv1NCNc0UQ="
        );

        return S3Presigner.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .build();
    }
}
