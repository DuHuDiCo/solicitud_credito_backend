
package com.estudio_credito_preaprobado.estudio_credito.payload.request;

import com.estudio_credito_preaprobado.estudio_credito.models.DataCredito;
import com.estudio_credito_preaprobado.estudio_credito.models.DatosPersonales;
import com.estudio_credito_preaprobado.estudio_credito.models.Foto;



public class DocumentosRequest {

    private CedulaRequest cedula_ciudadania_codeudor;
    
    
    private CedulaRequest cedula_ciudadania_comprador;
    
    private DataCredito dataCredito;
    
    private DatosPersonales datosPersonales;
    
    private Foto foto;

    public DocumentosRequest() {
    }

    public CedulaRequest getCedula_ciudadania_codeudor() {
        return cedula_ciudadania_codeudor;
    }

    public void setCedula_ciudadania_codeudor(CedulaRequest cedula_ciudadania_codeudor) {
        this.cedula_ciudadania_codeudor = cedula_ciudadania_codeudor;
    }

    public CedulaRequest getCedula_ciudadania_comprador() {
        return cedula_ciudadania_comprador;
    }

    public void setCedula_ciudadania_comprador(CedulaRequest cedula_ciudadania_comprador) {
        this.cedula_ciudadania_comprador = cedula_ciudadania_comprador;
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
