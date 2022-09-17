package com.estudio_credito_preaprobado.estudio_credito.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class ReferenciasPersonales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 100)
    private String nombre;
    
    @Size(max = 30)
    private String telefono;
    
    private String referencia;

}
