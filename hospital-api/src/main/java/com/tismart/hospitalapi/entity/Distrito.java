package com.tismart.hospitalapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Distrito {

    @Id
    @Column(name = "iddistrito")
    private Long idDistrito;
    @Column(name = "idprovincia")
    private Long idProvincia;
    @Transient
    private Provincia provincia;
    @Column(name = "descdistrito")
    private String desDistrito;
    @Column(name = "fecharegistro")
    private Timestamp fechaRegistro;
}
