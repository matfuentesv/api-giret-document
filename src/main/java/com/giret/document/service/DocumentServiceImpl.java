package com.giret.document.service;


import com.giret.document.model.Document;
import com.giret.document.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    S3Client s3Client;

    @Autowired
    DocumentRepository documentRepository;


    @Value("${app.s3.bucket}")
    private String bucketName;

    @Value("${app.s3.url-prefix}")
    private String s3UrlPrefix;



    @Override
    public Document saveDocument(File file, String key, String originalFileName, String mimeType, Long resouceId) {


        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(mimeType)
                .build();

        s3Client.putObject(request, RequestBody.fromFile(file));

        Document document = Document.builder()
                .nombreArchivo(originalFileName)
                .url(s3UrlPrefix + key)
                .tipoMime(mimeType)
                .fechaCarga(LocalDateTime.now().toString())
                .recursoId(resouceId)
                .build();

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
