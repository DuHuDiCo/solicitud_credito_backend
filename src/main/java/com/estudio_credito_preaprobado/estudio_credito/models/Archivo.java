
package com.estudio_credito_preaprobado.estudio_credito.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "archivo", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Archivo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_archivo;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "ruta", nullable = false, insertable = false, updatable = false)
    private String ruta;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "ruta", nullable = false)
    private Date fecha;
    
    

    public Archivo() {
        super();
    }

    public Archivo(Long id_archivo, String nombre, String ruta, Date fecha) {
        this.id_archivo = id_archivo;
        this.nombre = nombre;
        this.ruta = ruta;
        this.fecha = fecha;
    }

    public Long getId_archivo() {
        return id_archivo;
    }

    public void setId_archivo(Long id_archivo) {
        this.id_archivo = id_archivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
