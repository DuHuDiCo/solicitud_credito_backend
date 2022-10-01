
package com.estudio_credito_preaprobado.estudio_credito.payload.request;

import java.util.ArrayList;
import java.util.List;


public class ClienteRequest {

    List<Referencia_Comercial_Cliente> referencias_comerciales_cliente = new ArrayList<>();
    
    List<Referencia_Personal_Cliente> referencias_personales_cliente  = new ArrayList<>();
    
    private String observacion_cliente;

    public ClienteRequest() {
    }

    public List<Referencia_Comercial_Cliente> getReferencias_comerciales_cliente() {
        return referencias_comerciales_cliente;
    }

    public void setReferencias_comerciales_cliente(List<Referencia_Comercial_Cliente> referencias_comerciales_cliente) {
        this.referencias_comerciales_cliente = referencias_comerciales_cliente;
    }

    public List<Referencia_Personal_Cliente> getReferencias_personales_cliente() {
        return referencias_personales_cliente;
    }

    public void setReferencias_personales_cliente(List<Referencia_Personal_Cliente> referencias_personales_cliente) {
        this.referencias_personales_cliente = referencias_personales_cliente;
    }

   

   

    public String getObservacion_cliente() {
        return observacion_cliente;
    }

    public void setObservacion_cliente(String observacion_cliente) {
        this.observacion_cliente = observacion_cliente;
    }

    
    
    
   
    
}
