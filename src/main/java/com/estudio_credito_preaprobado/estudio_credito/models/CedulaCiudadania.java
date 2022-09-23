
package com.estudio_credito_preaprobado.estudio_credito.models;

import java.io.Serializable;
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
    
    
    
    private String frenteCedula;
    
    private String respaldoCedula;
    
    private String propietario;

    public CedulaCiudadania() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrenteCedula() {
        return frenteCedula;
    }

    public void setFrenteCedula(String frenteCedula) {
        this.frenteCedula = frenteCedula;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    

    public String getRespaldoCedula() {
        return respaldoCedula;
    }

    public void setRespaldoCedula(String respaldoCedula) {
        this.respaldoCedula = respaldoCedula;
    }
    
    

}
