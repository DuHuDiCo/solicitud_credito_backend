
package com.estudio_credito_preaprobado.estudio_credito.payload.request;

import com.estudio_credito_preaprobado.estudio_credito.models.Cliente;
import com.estudio_credito_preaprobado.estudio_credito.models.Codeudor;




public class SolicitudCreditoClienteRequest {
    
    
    private Long id;
    
    private Cliente cliente;
    
    private Codeudor codeudor;
   
    private DocumentosRequest documentos;
  
    private ReferenciasComercialesRequest referencias_comerciales;
    
    private ReferenciasPersonalesRequest referencias_personales;
    

    public SolicitudCreditoClienteRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Codeudor getCodeudor() {
        return codeudor;
    }

    public void setCodeudor(Codeudor codeudor) {
        this.codeudor = codeudor;
    }

    public DocumentosRequest getDocumentos() {
        return documentos;
    }

    public void setDocumentos(DocumentosRequest documentos) {
        this.documentos = documentos;
    }

    public ReferenciasComercialesRequest getReferencias_comerciales() {
        return referencias_comerciales;
    }

    public void setReferencias_comerciales(ReferenciasComercialesRequest referencias_comerciales) {
        this.referencias_comerciales = referencias_comerciales;
    }

    public ReferenciasPersonalesRequest getReferencias_personales() {
        return referencias_personales;
    }

    public void setReferencias_personales(ReferenciasPersonalesRequest referencias_personales) {
        this.referencias_personales = referencias_personales;
    }
    
    
     
    
    


    
    
    
    
    

}
