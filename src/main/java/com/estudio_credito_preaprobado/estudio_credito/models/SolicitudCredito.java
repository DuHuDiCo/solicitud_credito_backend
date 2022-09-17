package com.estudio_credito_preaprobado.estudio_credito.models;

import java.util.HashSet;
import java.util.Set;
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

@Entity
public class SolicitudCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    private Codeudor codeudor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "solicitud_credito_ventas", joinColumns = @JoinColumn(name = "solicitud_credito_id"), inverseJoinColumns = @JoinColumn(name = "ventas_id"))
    @Column(nullable = true)
    private Set<Venta> ventas = new HashSet<>();
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @Column(nullable = true)
    private Set<ReferenciasComerciales> referenciasComerciales = new HashSet<>();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @Column(nullable = true)
    private Set<ReferenciasPersonales> referenciasPersonales = new HashSet<>();

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

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }

    public Set<ReferenciasComerciales> getReferenciasComerciales() {
        return referenciasComerciales;
    }

    public Codeudor getCodeudor() {
        return codeudor;
    }

    public void setCodeudor(Codeudor codeudor) {
        this.codeudor = codeudor;
    }

    public void setReferenciasComerciales(Set<ReferenciasComerciales> referenciasComerciales) {
        this.referenciasComerciales = referenciasComerciales;
    }

    public Set<ReferenciasPersonales> getReferenciasPersonales() {
        return referenciasPersonales;
    }

    public void setReferenciasPersonales(Set<ReferenciasPersonales> referenciasPersonales) {
        this.referenciasPersonales = referenciasPersonales;
    }

}
