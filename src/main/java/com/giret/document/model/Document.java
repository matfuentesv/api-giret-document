package com.giret.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DOCUMENTO", schema = "ADMIN")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDDOCUMENTO")
    private Long id;

    @Column(name = "NOMBREARCHIVO", nullable = false)
    private String nombreArchivo;

    @Column(name = "URL", nullable = false)
    private String url;

    @Column(name = "TIPOMIME", nullable = false)
    private String tipoMime;

    @Column(name = "FECHACARGA")
    private String fechaCarga;

    @Column(name = "RECURSO_IDRECURSO", nullable = false)
    @JsonProperty("recursoId")
    private Long recursoId;

}
