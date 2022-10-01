
package com.estudio_credito_preaprobado.estudio_credito.payload.request;

import java.util.ArrayList;
import java.util.List;


public class CodeudorRequest {
    
    List<Referencia_Comercial_Codeudor> referencias_comerciales_codeudor = new ArrayList<>();
    
    List<Referencia_Personal_Codeudor> referencias_personales_codeudor = new  ArrayList<>();
    
    private String observacion_codeudor;

    public CodeudorRequest() {
    }

    public List<Referencia_Comercial_Codeudor> getReferencias_comerciales_codeudor() {
        return referencias_comerciales_codeudor;
    }

    public void setReferencias_comerciales_codeudor(List<Referencia_Comercial_Codeudor> referencias_comerciales_codeudor) {
        this.referencias_comerciales_codeudor = referencias_comerciales_codeudor;
    }

    public List<Referencia_Personal_Codeudor> getReferencias_personales_codeudor() {
        return referencias_personales_codeudor;
    }

    public void setReferencias_personales_codeudor(List<Referencia_Personal_Codeudor> referencias_personales_codeudor) {
        this.referencias_personales_codeudor = referencias_personales_codeudor;
    }

    public String getObservacion_codeudor() {
        return observacion_codeudor;
    }

    public void setObservacion_codeudor(String observacion_codeudor) {
        this.observacion_codeudor = observacion_codeudor;
    }
    
    
    

}
