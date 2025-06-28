package com.giret.document.controller;

import com.giret.document.model.Document;
import com.giret.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DocumentController {

    @Autowired
    DocumentService documentService;


    @PostMapping("/saveDucument")
    public ResponseEntity<Document> saveDocument(@RequestBody Document document) {
        return ResponseEntity.ok(documentService.saveDocument(document));
    }

    @GetMapping("/findAllDocumento")
    public ResponseEntity<List<Document>> findAllDocumento() {
        return ResponseEntity.ok(documentService.findAllDocument());
    }

    @GetMapping("/by-resource/{id}")
    public ResponseEntity<List<Document>> findByRecursoId(@PathVariable Long id) {
        return ResponseEntity.ok(documentService.findByResourceId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }

}
