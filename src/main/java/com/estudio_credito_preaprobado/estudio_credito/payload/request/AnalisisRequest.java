
package com.estudio_credito_preaprobado.estudio_credito.payload.request;


public class AnalisisRequest {
    
    private Long id;
    
    private Long usuario;
    
    private String observaciones;

    public AnalisisRequest() {
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }
    
    

}
