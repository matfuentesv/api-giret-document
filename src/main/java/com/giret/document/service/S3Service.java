package com.giret.document.service;

public interface S3Service {

    void uploadFile(String key, String filePath);
    void downloadFile(String key, String downloadPath);

}
