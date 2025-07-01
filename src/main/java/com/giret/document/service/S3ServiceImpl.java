package com.giret.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class S3ServiceImpl implements S3Service {

    @Autowired
    S3Client s3Client;

    @Value("${app.s3.bucket}")
    private String bucketName;

    @Override
    public void uploadFile(String key, String filePath) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromFile(Paths.get(filePath)));
        System.out.println("Archivo subido correctamente a S3: " + key);
    }

    @Override
    public void downloadFile(String key, String downloadDir) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        String fileName = Paths.get(key).getFileName().toString();
        Path targetPath = Paths.get(downloadDir, fileName);

        File parentDir = targetPath.toFile().getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        s3Client.getObject(getObjectRequest, targetPath);
        System.out.println("Archivo descargado correctamente: " + targetPath);
    }
}
