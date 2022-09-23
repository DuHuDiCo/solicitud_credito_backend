
package com.estudio_credito_preaprobado.estudio_credito.models;

import java.util.ArrayList;
import java.util.List;


public class Referencias {
    
    private List<ReferenciasComerciales> referenciasComerciales = new ArrayList<>();
    
    private List<ReferenciasPersonales> referenciasPersonales = new ArrayList<>();

    public Referencias() {
    }

    public List<ReferenciasComerciales> getReferenciasComercialeses() {
        return referenciasComerciales;
    }

    public void setReferenciasComercialeses(List<ReferenciasComerciales> referenciasComercialeses) {
        this.referenciasComerciales = referenciasComercialeses;
    }

    public List<ReferenciasPersonales> getReferenciasPersonaleses() {
        return referenciasPersonales;
    }

    public void setReferenciasPersonaleses(List<ReferenciasPersonales> referenciasPersonaleses) {
        this.referenciasPersonales = referenciasPersonaleses;
    }
    
    
    

}
