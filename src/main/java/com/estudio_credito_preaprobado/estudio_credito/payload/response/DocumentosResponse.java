
package com.estudio_credito_preaprobado.estudio_credito.payload.response;

import com.estudio_credito_preaprobado.estudio_credito.models.*;




public class DocumentosResponse {
    
    private Long id;
    
    
    
    
    
    private DataCreditoResponse dataCredito;
    
    
    
    
    private DatosPersonalesResponse datosPersonales;
    
    
    
    private Foto foto;

    public DocumentosResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public DataCreditoResponse getDataCredito() {
        return dataCredito;
    }

    public void setDataCredito(DataCreditoResponse dataCredito) {
        this.dataCredito = dataCredito;
    }

    public DatosPersonalesResponse getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonalesResponse datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
    
    
    
    
    
    
   

}
