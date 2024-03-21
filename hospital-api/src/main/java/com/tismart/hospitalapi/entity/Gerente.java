package com.tismart.hospitalapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gerente {

    @Id
    @Column(name = "idgerente")
    private Long idGerente;
    @Column(name = "descgerente")
    private String desGerente;
    @Column(name = "fecharegistro")
    private Timestamp fechaRegistro;
}
