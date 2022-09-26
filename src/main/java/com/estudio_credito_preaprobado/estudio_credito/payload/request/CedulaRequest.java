
package com.estudio_credito_preaprobado.estudio_credito.payload.request;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class CedulaRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    private String frente_cedula;
    
    
    private String respaldo_cedula;

    public CedulaRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrente_cedula() {
        return frente_cedula;
    }

    public void setFrente_cedula(String frente_cedula) {
        this.frente_cedula = frente_cedula;
    }

    public String getRespaldo_cedula() {
        return respaldo_cedula;
    }

    public void setRespaldo_cedula(String respaldo_cedula) {
        this.respaldo_cedula = respaldo_cedula;
    }
    
    

}
