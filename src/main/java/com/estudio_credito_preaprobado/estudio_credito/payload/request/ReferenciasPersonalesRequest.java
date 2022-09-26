
package com.estudio_credito_preaprobado.estudio_credito.payload.request;

import com.estudio_credito_preaprobado.estudio_credito.models.ReferenciasPersonales;
import java.util.ArrayList;
import java.util.List;


public class ReferenciasPersonalesRequest {
    
    
    List<ReferenciasPersonales> referencias_personales_codeudor = new ArrayList<>();
     
    List<ReferenciasPersonales> referencias_personales_comprador = new ArrayList<>();
    
    

    public ReferenciasPersonalesRequest() {
    }

    public List<ReferenciasPersonales> getReferencias_personales_comprador() {
        return referencias_personales_comprador;
    }

    public void setReferencias_personales_comprador(List<ReferenciasPersonales> referencias_personales_comprador) {
        this.referencias_personales_comprador = referencias_personales_comprador;
    }

    public List<ReferenciasPersonales> getReferencias_personales_codeudor() {
        return referencias_personales_codeudor;
    }

    public void setReferencias_personales_codeudor(List<ReferenciasPersonales> referencias_personales_codeudor) {
        this.referencias_personales_codeudor = referencias_personales_codeudor;
    }
    
    
    

}
