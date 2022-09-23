
package com.estudio_credito_preaprobado.estudio_credito.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



@Entity
public class Documentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "documentos_cedulas", joinColumns = @JoinColumn(name = "documentos_id"), inverseJoinColumns = @JoinColumn(name = "cedulas_id"))
    @Column(nullable = true)
    private Set<CedulaCiudadania> cedulasCiudadania = new HashSet<>();
    
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "data_credito_id", referencedColumnName = "id")
    private DataCredito dataCredito;
    
    
    
    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "datos_personales_id", referencedColumnName = "id")
    private DatosPersonales datosPersonales;
    
    
     
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "foto_id", referencedColumnName = "id")
    private Foto foto;

    public Documentos() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CedulaCiudadania> getCedulasCiudadania() {
        return cedulasCiudadania;
    }

    public void setCedulasCiudadania(Set<CedulaCiudadania> cedulasCiudadania) {
        this.cedulasCiudadania = cedulasCiudadania;
    }

    public DataCredito getDataCredito() {
        return dataCredito;
    }

    public void setDataCredito(DataCredito dataCredito) {
        this.dataCredito = dataCredito;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
    
    
    
    
    
    
   

}
