
package com.estudio_credito_preaprobado.estudio_credito.payload.response;


public class DataCreditoResponse {
   
    private Long id;
    
    
    private Boolean autorizacion;
    
    
   
    private String fecha;

    public DataCreditoResponse() {
    }

    public DataCreditoResponse(Boolean autorizacion, String fecha) {
        this.autorizacion = autorizacion;
        this.fecha = fecha;
    }

    public Boolean getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Boolean autorizacion) {
        this.autorizacion = autorizacion;
    }
    
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    

}
