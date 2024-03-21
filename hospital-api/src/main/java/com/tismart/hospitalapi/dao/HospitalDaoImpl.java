package com.tismart.hospitalapi.dao;

import com.tismart.hospitalapi.dto.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import javax.persistence.StoredProcedureQuery;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class HospitalDaoImpl implements IHospitalDao {

    private static final Logger logger = Logger.getLogger(HospitalDaoImpl.class.getName());
    private final EntityManager entityManager;

    public HospitalDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public BuscarHospitalesPorResponseDto buscarHospitalesPor(HospitalRequestDto requestDto)
            throws NullPointerException, IllegalArgumentException, PersistenceException {

        logger.info("---- PARAMETROS DE ENTRADA ---- ");
        logger.info("----NOMBRE: "+ requestDto.getNombre());
        logger.info("----SEDE: "+ requestDto.getIdSede());
        logger.info("----GERENTE: "+ requestDto.getIdGerente());
        logger.info("----DISTRITO: "+ requestDto.getIdDistrito());
        logger.info("----CONDICION: "+ requestDto.getIdCondicion());
        logger.info("---- ");

        BuscarHospitalesPorResponseDto busquedaDto = new BuscarHospitalesPorResponseDto();
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("PKG_HOSPITAL.SP_HOSPITAL_LISTAR");

        // Configuración de parámetros de entrada
        storedProcedure.registerStoredProcedureParameter("pi_nombre", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("pi_idDistrito", Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("pi_idProvincia", Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("pi_idGerente", Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("pi_idSede", Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("pi_idCondicion", Long.class, ParameterMode.IN);

        // Configuración de parámetros de salida
        storedProcedure.registerStoredProcedureParameter("po_hospitales_cursor", Void.class, ParameterMode.REF_CURSOR);
        storedProcedure.registerStoredProcedureParameter("po_salida_codigo", Integer.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("po_salida_mensaje", String.class, ParameterMode.OUT);

        // Asignación de valores a los parámetros de entrada
        storedProcedure.setParameter("pi_nombre", requestDto.getNombre());
        storedProcedure.setParameter("pi_idDistrito", requestDto.getIdDistrito());
        storedProcedure.setParameter("pi_idProvincia", requestDto.getIdProvincia());
        storedProcedure.setParameter("pi_idGerente", requestDto.getIdGerente());
        storedProcedure.setParameter("pi_idSede", requestDto.getIdSede());
        storedProcedure.setParameter("pi_idCondicion", requestDto.getIdCondicion());

        // Ejecución del procedimiento almacenado
        storedProcedure.execute();

        List<Object[]> resultList = storedProcedure.getResultList();
        List<HospitalResponseDto> hospitales = new ArrayList<>();

        logger.info("----CURSOR HOSPITAL: ");
        for (Object[] result : resultList) {
            HospitalResponseDto hospital = new HospitalResponseDto();
            hospital.setIdHospital(((BigDecimal) result[0]).longValue());
            hospital.setNombre((String) result[1]);
            hospital.setAntiguedad(((BigDecimal) result[2]).intValue());
            hospital.setArea(((BigDecimal) result[3]).doubleValue());
            hospital.setDistrito(((String) result[4]));
            hospital.setSede(((String) result[5]));
            hospital.setGerente(((String) result[6]));
            hospital.setCondicion(((String) result[7]));
            hospital.setFechaRegistro((Timestamp) result[8]);
            hospitales.add(hospital);
            logger.info("---- "+ hospital.getIdHospital()+" - "+ hospital.getNombre()+" - "
                    + hospital.getAntiguedad()+" - "+ hospital.getArea()+" - "+ hospital.getDistrito()+" - "
                    + hospital.getSede()+" - "+ hospital.getGerente()+" - "+ hospital.getCondicion()+" - "
                    + hospital.getFechaRegistro()+" - ");
        }


        Integer codigoSalida = (Integer) storedProcedure.getOutputParameterValue("po_salida_codigo");
        String mensajeSalida = (String) storedProcedure.getOutputParameterValue("po_salida_mensaje");
        ResponseDto responseDto = ResponseDto.builder().codigoRespuesta(codigoSalida).mensajeRespuesta(mensajeSalida).build();

        busquedaDto.setHospitales(hospitales);
        busquedaDto.setRespuesta(responseDto);

        return busquedaDto;
    }

    @Override
    public ResponseDto registrarHospital(HospitalRequestDto requestDto)
            throws NullPointerException, IllegalArgumentException, PersistenceException{

        logger.info("---- PARAMETROS DE ENTRADA ---- ");
        logger.info("----NOMBRE: "+ requestDto.getNombre());
        logger.info("----ANTIGUEDAD: "+ requestDto.getAntiguedad());
        logger.info("----AREA: "+ requestDto.getArea());
        logger.info("----SEDE: "+ requestDto.getIdSede());
        logger.info("----GERENTE: "+ requestDto.getIdGerente());
        logger.info("----DISTRITO: "+ requestDto.getIdDistrito());
        logger.info("----CONDICION: "+ requestDto.getIdCondicion());
        logger.info("---- ");

        StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("Hospital.registrarHospital");
        storedProcedure.setParameter("pi_area", requestDto.getArea());
        storedProcedure.setParameter("pi_nombre", requestDto.getNombre());
        storedProcedure.setParameter("pi_antiguedad", requestDto.getAntiguedad());
        storedProcedure.setParameter("pi_idSede", requestDto.getIdSede());
        storedProcedure.setParameter("pi_idGerente", requestDto.getIdGerente());
        storedProcedure.setParameter("pi_idDistrito", requestDto.getIdDistrito());
        storedProcedure.setParameter("pi_idCondicion", requestDto.getIdCondicion());

        storedProcedure.execute();

        Integer codigoSalida = (Integer) storedProcedure.getOutputParameterValue("po_salida_codigo");
        String mensajeSalida = (String) storedProcedure.getOutputParameterValue("po_salida_mensaje");

        ResponseDto response = ResponseDto.builder()
                .codigoRespuesta(codigoSalida)
                .mensajeRespuesta(mensajeSalida)
                .build();

        return response;
    }

    @Override
    public ResponseDto actualizarHospital(HospitalRequestDto requestDto, Long id)
            throws NullPointerException, IllegalArgumentException, PersistenceException{
        StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("Hospital.actualizarHospital");
        storedProcedure.setParameter("pi_idHospital", id);
        storedProcedure.setParameter("pi_area", requestDto.getArea());
        storedProcedure.setParameter("pi_nombre", requestDto.getNombre());
        storedProcedure.setParameter("pi_antiguedad", requestDto.getAntiguedad());
        storedProcedure.setParameter("pi_idSede", requestDto.getIdSede());
        storedProcedure.setParameter("pi_idGerente", requestDto.getIdGerente());
        storedProcedure.setParameter("pi_idDistrito", requestDto.getIdDistrito());
        storedProcedure.setParameter("pi_idCondicion", requestDto.getIdCondicion());

        storedProcedure.execute();

        Integer codigoSalida = (Integer) storedProcedure.getOutputParameterValue("po_salida_codigo");
        String mensajeSalida = (String) storedProcedure.getOutputParameterValue("po_salida_mensaje");

        ResponseDto response = ResponseDto.builder()
                .codigoRespuesta(codigoSalida)
                .mensajeRespuesta(mensajeSalida)
                .build();

        return response;
    }

    @Override
    public ResponseDto eliminarHospital(Long id)
            throws NullPointerException, IllegalArgumentException, PersistenceException{
        StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("Hospital.eliminarHospital");
        storedProcedure.setParameter("pi_idHospital", id);

        storedProcedure.execute();

        Integer codigoSalida = (Integer) storedProcedure.getOutputParameterValue("po_salida_codigo");
        String mensajeSalida = (String) storedProcedure.getOutputParameterValue("po_salida_mensaje");

        ResponseDto response = ResponseDto.builder()
                .codigoRespuesta(codigoSalida)
                .mensajeRespuesta(mensajeSalida)
                .build();

        return response;
    }
}
