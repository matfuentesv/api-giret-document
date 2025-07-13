package com.giret.document.controller;

import com.giret.document.model.Document;
import com.giret.document.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DocumentController {


    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/saveDocument")
    public ResponseEntity<Document> upload(@RequestParam("file") MultipartFile multipartFile,
                                           @RequestParam("recursoId") Long recursoId) {
        try {

            String objectKey = "uploads/" + recursoId + "/" + multipartFile.getOriginalFilename();


            File file = File.createTempFile("upload-", multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);


            Document savedDoc = documentService.saveDocument(
                    file,
                    objectKey,
                    multipartFile.getOriginalFilename(),
                    multipartFile.getContentType(),
                    recursoId
            );


             file.delete();

            return ResponseEntity.ok(savedDoc);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/by-resource/{recursoId}")
    public ResponseEntity<List<Document>> getDocumentsByRecursoId(@PathVariable Long recursoId) {
        List<Document> documents = documentService.findByResourceId(recursoId);

        return ResponseEntity.ok(documents);
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
