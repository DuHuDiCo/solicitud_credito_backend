
package com.estudio_credito_preaprobado.estudio_credito.payload.request;

import com.estudio_credito_preaprobado.estudio_credito.models.ReferenciasComerciales;
import java.util.ArrayList;
import java.util.List;


public class ReferenciasComercialesRequest {
    
    
    List<ReferenciasComerciales> referencias_comerciales_comprador = new ArrayList<>();
    
    List<ReferenciasComerciales> referencias_comerciales_codeudor = new ArrayList<>();

    public ReferenciasComercialesRequest() {
    }

    public List<ReferenciasComerciales> getReferencias_comerciales_comprador() {
        return referencias_comerciales_comprador;
    }

    public void setReferencias_comerciales_comprador(List<ReferenciasComerciales> referencias_comerciales_comprador) {
        this.referencias_comerciales_comprador = referencias_comerciales_comprador;
    }

    public List<ReferenciasComerciales> getReferencias_comerciales_codeudor() {
        return referencias_comerciales_codeudor;
    }

    public void setReferencias_comerciales_codeudor(List<ReferenciasComerciales> referencias_comerciales_codeudor) {
        this.referencias_comerciales_codeudor = referencias_comerciales_codeudor;
    }
    
    
    

}
