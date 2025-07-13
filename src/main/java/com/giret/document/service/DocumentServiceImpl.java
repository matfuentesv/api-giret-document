package com.giret.document.service;


import com.giret.document.model.Document;
import com.giret.document.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {


    final private S3Client s3Client;

    private final S3Presigner s3Presigner;

    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(S3Client s3Client, S3Presigner s3Presigner, DocumentRepository documentRepository) {
        this.s3Client = s3Client;
        this.s3Presigner = s3Presigner;
        this.documentRepository = documentRepository;
    }

    @Value("${app.s3.bucket}")
    private String bucketName;

    @Value("${app.s3.url-prefix}")
    private String s3UrlPrefix;

    @Override
    public Document saveDocument(File file, String key, String originalFilename, String contentType, Long recursoId) {

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(contentType)
                .build();

        s3Client.putObject(request, RequestBody.fromFile(file));


        Document document = new Document();
        document.setKey(key);
        document.setNombreArchivo(originalFilename);
        document.setTipoMime(contentType);
        document.setRecursoId(recursoId);
        document.setFechaCarga(LocalDateTime.now().toString());
        return documentRepository.save(document);
    }

    @Override
    public List<Document> findAllDocument() {
        return documentRepository.findAll();
    }

    @Override
    public List<Document> findByResourceId(Long resourceId) {
        List<Document> documents = documentRepository.findByRecursoId(resourceId);
        return documents.stream()
                .filter(doc -> doc.getKey() != null)
                .map(doc -> {
                    URL presignedUrl = generatePresignedUrl(doc.getKey());
                    doc.setUrl(presignedUrl.toString());
                    return doc;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDocument(Long idDocument) {
        documentRepository.deleteById(idDocument);
    }


    public List<Document> getDocumentsByRecursoId(Long recursoId) {
        List<Document> documents = documentRepository.findByRecursoId(recursoId);
        return documents.stream()
                .peek(doc -> {
                    URL presignedUrl = generatePresignedUrl(doc.getKey());
                    doc.setUrl(presignedUrl.toString());
                })
                .collect(Collectors.toList());
    }


    URL generatePresignedUrl(String objectKey) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();

        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(5))
                .getObjectRequest(getObjectRequest)
                .build();

        return s3Presigner.presignGetObject(presignRequest).url();
    }
}
