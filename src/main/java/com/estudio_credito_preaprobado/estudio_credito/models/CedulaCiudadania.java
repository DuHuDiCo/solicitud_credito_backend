
package com.estudio_credito_preaprobado.estudio_credito.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cedula_ciudadania")
public class CedulaCiudadania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    
    private String frente_cedula;
    
    private String propietario;
    
    private String respaldo_cedula;
    
    

    public CedulaCiudadania() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrenteCedula() {
        return frente_cedula;
    }

    public void setFrenteCedula(String frenteCedula) {
        this.frente_cedula = frenteCedula;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    

    public String getRespaldoCedula() {
        return respaldo_cedula;
    }

    public void setRespaldoCedula(String respaldoCedula) {
        this.respaldo_cedula = respaldoCedula;
    }
    
    

}
