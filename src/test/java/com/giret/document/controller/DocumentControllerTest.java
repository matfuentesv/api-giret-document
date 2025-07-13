package com.giret.document.controller;

import com.giret.document.model.Document;
import com.giret.document.service.DocumentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;


import java.io.File;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DocumentController.class)
class DocumentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DocumentService documentService;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public DocumentService documentService() {
            return Mockito.mock(DocumentService.class);
        }
    }

    private Document document;

    @BeforeEach
    void setUp() {
        document = new Document();
        document.setId(1L);
        document.setRecursoId(100L);
        document.setNombreArchivo("file.txt");
        document.setUrl("https://s3.amazonaws.com/bucket/file.txt");
        document.setFechaCarga("2024-07-15 12:00:00");
    }


    @Test
    void shouldUploadDocument() throws Exception {
        when(documentService.saveDocument(
                any(File.class),
                anyString(),
                anyString(),
                anyString(),
                anyLong()
        )).thenReturn(document);

        MockMultipartFile file = new MockMultipartFile(
                "file",
                "file.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Contenido de prueba".getBytes()
        );

        mockMvc.perform(multipart("/api/saveDocument")
                        .file(file)
                        .param("recursoId", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombreArchivo").value("file.txt"))
                .andExpect(jsonPath("$.recursoId").value(100))
                .andExpect(jsonPath("$.fechaCarga").value("2024-07-15 12:00:00"));
    }


    @Test
    void shouldGetAllDocuments() throws Exception {
        when(documentService.findAllDocument()).thenReturn(List.of(document));

        mockMvc.perform(get("/api/findAllDocumento"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombreArchivo").value("file.txt"))
                .andExpect(jsonPath("$[0].recursoId").value(100))
                .andExpect(jsonPath("$[0].fechaCarga").value("2024-07-15 12:00:00"));
    }

    @Test
    void shouldFindDocumentByResourceId() throws Exception {
        when(documentService.findByResourceId(100L)).thenReturn(List.of(document));

        mockMvc.perform(get("/api/by-resource/100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombreArchivo").value("file.txt"))
                .andExpect(jsonPath("$[0].recursoId").value(100))
                .andExpect(jsonPath("$[0].fechaCarga").value("2024-07-15 12:00:00"));
    }

    @Test
    void shouldDeleteDocumentoById() throws Exception {
        Long id = 123L;


        doNothing().when(documentService).deleteDocument(id);

        mockMvc.perform(delete("/api/{id}", id))
                .andExpect(status().isNoContent());

        verify(documentService, times(1)).deleteDocument(id);
    }

    @Test
    void shouldReturnInternalServerErrorWhenExceptionOccursInUpload() throws Exception {

        MockMultipartFile multipartFile = new MockMultipartFile(
                "file", "test.txt", "text/plain", "Hello World".getBytes());

        Long recursoId = 1L;


        when(documentService.saveDocument(any(File.class), anyString(), anyString(), anyString(), anyLong()))
                .thenThrow(new RuntimeException("Simulated Exception"));


        mockMvc.perform(multipart("/api/saveDocument")
                        .file(multipartFile)
                        .param("recursoId", recursoId.toString()))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("")); // porque body(null)

        verify(documentService).saveDocument(any(), any(), any(), any(), eq(recursoId));
    }



}