package com.giret.document.service;

import com.giret.document.model.Document;

import java.util.List;


public interface DocumentService {

    Document saveDocument(Document document);
    List<Document> findAllDocument();
    List<Document> findByResourceId(Long resourceId);
    void deleteDocument(Long idDocument);
}
