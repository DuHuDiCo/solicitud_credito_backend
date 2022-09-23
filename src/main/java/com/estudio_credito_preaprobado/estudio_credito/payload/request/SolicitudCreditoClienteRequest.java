
package com.estudio_credito_preaprobado.estudio_credito.payload.request;

import com.estudio_credito_preaprobado.estudio_credito.models.Cliente;
import com.estudio_credito_preaprobado.estudio_credito.models.Codeudor;
import com.estudio_credito_preaprobado.estudio_credito.models.Documentos;
import com.estudio_credito_preaprobado.estudio_credito.models.Referencias;




public class SolicitudCreditoClienteRequest {
    
    
    private Long id;
    
    private Cliente cliente;
    
    private Codeudor codeudor;
   
    private Documentos documentos;
  
       
    private Referencias referencias;

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

    public Documentos getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documentos documentos) {
        this.documentos = documentos;
    }

    public Referencias getReferencias() {
        return referencias;
    }

    public void setReferencias(Referencias referencias) {
        this.referencias = referencias;
    }
    
    


    
    
    
    
    

}
