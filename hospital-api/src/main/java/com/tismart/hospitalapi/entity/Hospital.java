package com.tismart.hospitalapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedStoredProcedureQuery(
        name = "Hospital.registrarHospital",
        procedureName = "PKG_HOSPITAL.SP_HOSPITAL_REGISTRAR",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_idDistrito", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_nombre", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_antiguedad", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_area", type = Double.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_idSede", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_idGerente", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_idCondicion", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "po_salida_codigo", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "po_salida_mensaje", type = String.class)
        }
)
@NamedStoredProcedureQuery(
        name = "Hospital.actualizarHospital",
        procedureName = "PKG_HOSPITAL.SP_HOSPITAL_ACTUALIZAR",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_idHospital", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_nombre", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_antiguedad", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_area", type = Double.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_idDistrito", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_idSede", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_idGerente", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_idCondicion", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "po_salida_codigo", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "po_salida_mensaje", type = String.class)
        }
)
@NamedStoredProcedureQuery(
        name = "Hospital.eliminarHospital",
        procedureName = "PKG_HOSPITAL.SP_HOSPITAL_ELIMINAR",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_idHospital", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "po_salida_codigo", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "po_salida_mensaje", type = String.class)
        }
)
public class Hospital implements Serializable {

    @Id
    @Column(name = "idhospital")
    private Long idHospital;
    private String nombre;
    private int antiguedad;
    private double area;
    @Column(name = "iddistrito")
    private Long idDistrito;
    @Column(name = "idsede")
    private Long idSede;
    @Column(name = "idgerente")
    private Long idGerente;
    @Column(name = "idcondicion")
    private Long idCondicion;
    @Column(name = "fecharegistro")
    private Timestamp fechaRegistro;
    @Transient
    private Distrito distrito;
    @Transient
    private Sede sede;
    @Transient
    private Gerente gerente;
    @Transient
    private Condicion condicion;

}
