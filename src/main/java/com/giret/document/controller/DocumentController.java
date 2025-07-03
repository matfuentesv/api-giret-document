package com.giret.document.controller;

import com.giret.document.model.Document;
import com.giret.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DocumentController {

    @Autowired
    DocumentService documentService;


    @PostMapping("/saveDocument")
    public ResponseEntity<Document> upload(@RequestParam("file") MultipartFile file,
                                           @RequestParam("recursoId") Long recursoId) throws IOException {

        // Crea archivo temporal
        File tempFile = File.createTempFile("upload-", ".tmp");
        file.transferTo(tempFile);

        // Construye el key con carpeta por recurso
        String folderName = "recurso-" + recursoId;
        String fileName = file.getOriginalFilename();
        String key = folderName + "/" + fileName;

        Document doc = documentService.saveDocument(
                tempFile,
                key,
                file.getOriginalFilename(),
                file.getContentType(),
                recursoId
        );

        return ResponseEntity.ok(doc);
    }

    @GetMapping("/by-resource/{id}")
    public ResponseEntity<List<Document>> findByRecursoId(@PathVariable Long id) {
        return ResponseEntity.ok(documentService.findByResourceId(id));
    }

    @GetMapping("/findAllDocumento")
    public ResponseEntity<List<Document>> findAllDocumento() {
        return ResponseEntity.ok(documentService.findAllDocument());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }

}
