package com.giret.document.service;

import com.giret.document.model.Document;

import java.io.File;
import java.util.List;


public interface DocumentService {

    Document saveDocument(File file, String key, String originalFilename, String contentType, Long recursoId);
    List<Document> findAllDocument();
    List<Document> findByResourceId(Long resourceId);
    void deleteDocument(Long idDocument);
}
