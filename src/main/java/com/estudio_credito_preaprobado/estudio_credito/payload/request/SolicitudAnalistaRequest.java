
package com.estudio_credito_preaprobado.estudio_credito.payload.request;


public class SolicitudAnalistaRequest {
    
    private Long id;
            
    
    private ClienteRequest cliente;
    
    private CodeudorRequest codeudor;
    
    private AnalisisRequest analisis;
    
    private String estado;

    public SolicitudAnalistaRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteRequest getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRequest cliente) {
        this.cliente = cliente;
    }

    public CodeudorRequest getCodeudor() {
        return codeudor;
    }

    public void setCodeudor(CodeudorRequest codeudor) {
        this.codeudor = codeudor;
    }

    public AnalisisRequest getAnalisis() {
        return analisis;
    }

    public void setAnalisis(AnalisisRequest analisis) {
        this.analisis = analisis;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    

    

    
    
    
}
