
package com.estudio_credito_preaprobado.estudio_credito.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 50)
    private String referencia;
    
    @Size(max = 100)
    private String producto;
    
    
    private float pago_inicial;
    
    private int cuotas;
    
    private float valor_producto;

    public Venta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public float getPago_inicial() {
        return pago_inicial;
    }

    public void setPago_inicial(float pago_inicial) {
        this.pago_inicial = pago_inicial;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public float getValor_producto() {
        return valor_producto;
    }

    public void setValor_producto(float valor_producto) {
        this.valor_producto = valor_producto;
    }

    
    
    

}
