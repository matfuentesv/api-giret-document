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


    @Override
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public List<Document> findAllDocument() {
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
