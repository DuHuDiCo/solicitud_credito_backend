
package com.estudio_credito_preaprobado.estudio_credito.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cedula_ciudadania_codeudor")
public class CedulaCiudadaniaCodeudor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    
    
    private String frente_cedula;
    
    
    
    private String respaldo_cedula;
    
    

    public CedulaCiudadaniaCodeudor() {
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
