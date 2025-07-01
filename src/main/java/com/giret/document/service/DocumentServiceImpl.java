package com.giret.document.service;


import com.giret.document.model.Document;
import com.giret.document.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    S3Service s3Service;


    @Override
    public Document saveDocument(Document document) {

        s3Service.uploadFile("file.pdf","C:/Forum/CREAM/Documento de prueba.pdf");
        return documentRepository.save(document);
    }

    @Override
    public List<Document> findAllDocument() {
        s3Service.downloadFile("file.pdf","C:/Forum/CREAM/s3");
        return documentRepository.findAll();
    }

    @Override
    public List<Document> findByResourceId(Long resourceId) {
        return documentRepository.findByRecursoId(resourceId);
    }

    @Override
    public void deleteDocument(Long idDocument) {
        documentRepository.deleteById(idDocument);
    }
}
