package com.estudio_credito_preaprobado.estudio_credito.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SolicitudCredito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Codeudor codeudor;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "documentos_id", referencedColumnName = "id")
    private Documentos documentos;
    

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "solicitud_credito_ventas", joinColumns = @JoinColumn(name = "solicitud_credito_id"), inverseJoinColumns = @JoinColumn(name = "ventas_id"))
    @Column(nullable = true)
    private List<Venta> ventas = new ArrayList<>();
    
    
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @Column(nullable = true)
    private List<ReferenciasComerciales> referenciasComerciales = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @Column(nullable = true)
    private List<ReferenciasPersonales> referenciasPersonales = new ArrayList<>();

    public SolicitudCredito() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<ReferenciasComerciales> getReferenciasComerciales() {
        return referenciasComerciales;
    }

    public Codeudor getCodeudor() {
        return codeudor;
    }

    public void setCodeudor(Codeudor codeudor) {
        this.codeudor = codeudor;
    }

    public void setReferenciasComerciales(List<ReferenciasComerciales> referenciasComerciales) {
        this.referenciasComerciales = referenciasComerciales;
    }

    public List<ReferenciasPersonales> getReferenciasPersonales() {
        return referenciasPersonales;
    }

    public void setReferenciasPersonales(List<ReferenciasPersonales> referenciasPersonales) {
        this.referenciasPersonales = referenciasPersonales;
    }

    public Documentos getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documentos documentos) {
        this.documentos = documentos;
    }
    
    

}
