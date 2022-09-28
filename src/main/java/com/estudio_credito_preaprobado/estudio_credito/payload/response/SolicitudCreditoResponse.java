
package com.estudio_credito_preaprobado.estudio_credito.payload.response;

import com.estudio_credito_preaprobado.estudio_credito.models.Cliente;
import com.estudio_credito_preaprobado.estudio_credito.models.Codeudor;
import com.estudio_credito_preaprobado.estudio_credito.models.Venta;
import java.util.ArrayList;
import java.util.List;


public class SolicitudCreditoResponse {
    
   
    private Long id;
    
    
    private Cliente cliente;

    
    private Codeudor codeudor;
    
   
    private DocumentosResponse documentos;
    

    
    private List<Venta> ventas = new ArrayList<>();
    
     
   
    private String fecha;
    
   
    private String estado;

    public SolicitudCreditoResponse() {
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

    public DocumentosResponse getDocumentos() {
        return documentos;
    }

    public void setDocumentos(DocumentosResponse documentos) {
        this.documentos = documentos;
    }

    

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

}
