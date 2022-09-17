
package com.estudio_credito_preaprobado.estudio_credito.models;


public class VentaTotal {
    
     
    private Long id;
    
   
    private String referencia;
    
    
    private String producto;
    
    
    private float pago_inicial;
    
    private int cuotas;
    
    private float valor_total;

    public VentaTotal() {
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

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }
    
   

}
