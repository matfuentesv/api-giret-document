package com.giret.document.service;

import com.giret.document.model.Document;
import com.giret.document.repository.DocumentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DocumentServiceImplTest {

    @InjectMocks
    private DocumentServiceImpl documentService;

    @Mock
    private S3Client s3Client;

    @Mock
    private S3Presigner s3Presigner;

    @Mock
    private DocumentRepository documentRepository;




    @Test
    void shouldFindAllDocuments() {
        Document doc1 = new Document();
        Document doc2 = new Document();

        when(documentRepository.findAll()).thenReturn(List.of(doc1, doc2));

        List<Document> result = documentService.findAllDocument();

        assertThat(result).hasSize(2);
        verify(documentRepository, times(1)).findAll();
    }



    @Test
    void shouldDeleteDocumentById() {
        Long id = 99L;

        doNothing().when(documentRepository).deleteById(id);

        documentService.deleteDocument(id);

        verify(documentRepository, times(1)).deleteById(id);
    }

    @Test
    void shouldGetDocumentsByRecursoIdAndSetPresignedUrls() throws Exception {

        Long recursoId = 1L;

        Document doc = new Document();
        doc.setKey("file-key");

        when(documentRepository.findByRecursoId(recursoId)).thenReturn(List.of(doc));


        DocumentServiceImpl spyService = Mockito.spy(documentService);

        URL fakeUrl = new URL("http://localhost/fake-presigned-url");
        doReturn(fakeUrl).when(spyService).generatePresignedUrl("file-key");


        List<Document> result = spyService.getDocumentsByRecursoId(recursoId);


        assertThat(result).hasSize(1);
        assertThat(result.get(0).getUrl()).isEqualTo(fakeUrl.toString());

        verify(documentRepository).findByRecursoId(recursoId);
        verify(spyService).generatePresignedUrl("file-key");
    }

    @Test
    void shouldFindByResourceIdAndSetPresignedUrls() throws Exception {

        Long recursoId = 1L;

        Document doc1 = new Document();
        doc1.setKey("key1");

        Document doc2 = new Document();
        doc2.setKey(null);

        when(documentRepository.findByRecursoId(recursoId)).thenReturn(List.of(doc1, doc2));


        DocumentServiceImpl spyService = Mockito.spy(documentService);

        URL fakeUrl = new URL("http://localhost/fake-presigned-url");
        doReturn(fakeUrl).when(spyService).generatePresignedUrl("key1");


        List<Document> result = spyService.findByResourceId(recursoId);


        assertThat(result).hasSize(1);
        assertThat(result.get(0).getUrl()).isEqualTo(fakeUrl.toString());
        assertThat(result.get(0).getKey()).isEqualTo("key1");

        verify(documentRepository).findByRecursoId(recursoId);
        verify(spyService).generatePresignedUrl("key1");
    }


    @Test
    void shouldSaveDocumentSuccessfully() throws IOException {

        File tempFile = File.createTempFile("test", ".txt");
        tempFile.deleteOnExit();

        String key = "documents/test.txt";
        String originalFilename = "test.txt";
        String contentType = "text/plain";
        Long recursoId = 123L;

        Document savedDocument = new Document();
        savedDocument.setKey(key);
        savedDocument.setNombreArchivo(originalFilename);
        savedDocument.setTipoMime(contentType);
        savedDocument.setRecursoId(recursoId);

        when(documentRepository.save(any(Document.class))).thenReturn(savedDocument);

        Document result = documentService.saveDocument(tempFile, key, originalFilename, contentType, recursoId);
        verify(documentRepository, times(1)).save(any(Document.class));
        assertThat(result).isNotNull();
    }
}
