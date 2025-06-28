package com.giret.document.repository;


import com.giret.document.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByRecursoId(Long recursoId);


}
