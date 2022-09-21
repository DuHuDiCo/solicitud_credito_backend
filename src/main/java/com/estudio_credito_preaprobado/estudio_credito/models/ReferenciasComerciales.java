
package com.estudio_credito_preaprobado.estudio_credito.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class ReferenciasComerciales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 100)
    private String nombre;
    
    @Size(max = 30)
    private String telefono;
    
    
    private String referencia;
    
    
    
   

    public ReferenciasComerciales() {
    }

    public ReferenciasComerciales(String nombre, String telefono, String referencia) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.referencia = referencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    
    
    

}
