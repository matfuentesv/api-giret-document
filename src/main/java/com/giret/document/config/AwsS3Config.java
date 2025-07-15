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
                "ASIAUIIHPI6SRZPQAEUM",
                "JjfYUMiXrJiSEKtZyv5ryBRPATD+imy9d2mQiL2W",
                "IQoJb3JpZ2luX2VjEB4aCXVzLXdlc3QtMiJHMEUCIQDwsoTI7rl1aPViwp0fBhMbDutXBY2PXbuuSd7vpkQ5pAIgbgjm3ANR0lPVodgEmPMtV1PWv9+lT5Se+4LKoiH1oiwqsQIINxABGgwyOTI2MTAzMjg0ODUiDJkvcBpOuoAu/ar+9CqOAvv/B4I2fqm0UPk3H6xy3sO5rricyedGHOMFs90TLTSYK7MvNko6RICOWbCaf4jldLDeY0WsNqQ4fm29hbV4LqNQDiz+HgMnFyubHibvFY1u4JXH9yd7TbwRBKAmd62joPxYfcVGy3ilsB3fjJPbgd71q5wRRHc2k49lTjyTV2gpu/X/gHv96negQP0mRQ9ykPwgXeuAGaNmWTfhdRWd//MMvH2fedYh0vbqx0VVy7ZeZZHf3kH8RP/I7Yrbos3dqrZWxdO96dTQ1dkAAwFSoqPc1fRrbt1v7ZgVSF6YqeaEtQ/F//ofdmZRK4Gjtyt3NutLZVO2YYKWvXIIPdqimaS59nAdsTnCcl9+kWnYbTCo89XDBjqdAVVLRUnaq/WwPlC6CrRXqqTRPwxS2PKGB/DV10YlPQI1lNm6DwWLTfnMhZ/n2zQoLwqiVOIL6j+KqR/N8LWe4hEtocTpQo0woajMMnX7AMYFuyrgWrAOa0IQKk9GeVpQe4/2P2IznpoBgJWVp4yIPVHUHxPKSLiRmTr+Z3PoUVWTqW/oj1ADcbflJGGAHSu2wgrzG5v3Bof9upDsxLI="
        );

        return S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .build();
    }

    @Bean
    public S3Presigner s3Presigner() {
        AwsSessionCredentials sessionCredentials = AwsSessionCredentials.create(
                "ASIAUIIHPI6SRZPQAEUM",
                "JjfYUMiXrJiSEKtZyv5ryBRPATD+imy9d2mQiL2W",
                "IQoJb3JpZ2luX2VjEB4aCXVzLXdlc3QtMiJHMEUCIQDwsoTI7rl1aPViwp0fBhMbDutXBY2PXbuuSd7vpkQ5pAIgbgjm3ANR0lPVodgEmPMtV1PWv9+lT5Se+4LKoiH1oiwqsQIINxABGgwyOTI2MTAzMjg0ODUiDJkvcBpOuoAu/ar+9CqOAvv/B4I2fqm0UPk3H6xy3sO5rricyedGHOMFs90TLTSYK7MvNko6RICOWbCaf4jldLDeY0WsNqQ4fm29hbV4LqNQDiz+HgMnFyubHibvFY1u4JXH9yd7TbwRBKAmd62joPxYfcVGy3ilsB3fjJPbgd71q5wRRHc2k49lTjyTV2gpu/X/gHv96negQP0mRQ9ykPwgXeuAGaNmWTfhdRWd//MMvH2fedYh0vbqx0VVy7ZeZZHf3kH8RP/I7Yrbos3dqrZWxdO96dTQ1dkAAwFSoqPc1fRrbt1v7ZgVSF6YqeaEtQ/F//ofdmZRK4Gjtyt3NutLZVO2YYKWvXIIPdqimaS59nAdsTnCcl9+kWnYbTCo89XDBjqdAVVLRUnaq/WwPlC6CrRXqqTRPwxS2PKGB/DV10YlPQI1lNm6DwWLTfnMhZ/n2zQoLwqiVOIL6j+KqR/N8LWe4hEtocTpQo0woajMMnX7AMYFuyrgWrAOa0IQKk9GeVpQe4/2P2IznpoBgJWVp4yIPVHUHxPKSLiRmTr+Z3PoUVWTqW/oj1ADcbflJGGAHSu2wgrzG5v3Bof9upDsxLI="
        );

        return S3Presigner.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .build();
    }
}
