
package com.estudio_credito_preaprobado.estudio_credito.payload.response;


public class DatosPersonalesResponse {
    
  
    private Long id;
    
    
    
    private Boolean autorizacion;
    
  
    private String fecha;


    public DatosPersonalesResponse() {
    }

    public DatosPersonalesResponse(Boolean autorizacion, String fecha) {
        this.autorizacion = autorizacion;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    

    
    

}
