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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documento_seq")
    @SequenceGenerator(name = "documento_seq", sequenceName = "ADMIN.DOCUMENTO_SEQ", allocationSize = 1)
    @Column(name = "IDDOCUMENTO")
    @JsonProperty("idDocumento")
    private Long idDocumento;

    @Column(name = "NOMBREARCHIVO", nullable = false)
    @JsonProperty("nombreArchivo")
    private String nombreArchivo;

    @Column(name = "RUTAARCHIVO", nullable = false, length = 200)
    @JsonProperty("rutaArchivo")
    private String rutaArchivo;

    @Column(name = "FECHACARGA", nullable = false)
    @JsonProperty("fechaCarga")
    private String fechaCarga;

    @Column(name = "RECURSO_IDRECURSO", nullable = false)
    @JsonProperty("recursoId")
    private Long recursoId;

}
