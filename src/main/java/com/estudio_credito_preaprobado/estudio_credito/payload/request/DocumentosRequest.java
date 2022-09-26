
package com.estudio_credito_preaprobado.estudio_credito.payload.request;

import com.estudio_credito_preaprobado.estudio_credito.models.DataCredito;
import com.estudio_credito_preaprobado.estudio_credito.models.DatosPersonales;
import com.estudio_credito_preaprobado.estudio_credito.models.Foto;



public class DocumentosRequest {

    
    private DataCredito dataCredito;
    
    private DatosPersonales datosPersonales;
    
    private Foto foto;

    public DocumentosRequest() {
    }

   

    

    public DataCredito getDataCredito() {
        return dataCredito;
    }

    public void setDataCredito(DataCredito dataCredito) {
        this.dataCredito = dataCredito;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
    
    
}
