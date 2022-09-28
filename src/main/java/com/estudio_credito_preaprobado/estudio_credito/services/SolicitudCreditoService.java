
package com.estudio_credito_preaprobado.estudio_credito.services;

import com.estudio_credito_preaprobado.estudio_credito.models.SolicitudCredito;
import com.estudio_credito_preaprobado.estudio_credito.repository.SolicitudCreditoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudCreditoService {
    
    @Autowired
    private SolicitudCreditoRepository solicitudCreditoRepository;
    
    
    public SolicitudCredito crearSolicitudCredito(SolicitudCredito solicitudCredito){
        return solicitudCreditoRepository.save(solicitudCredito);
    }
    
    public List<SolicitudCredito> obtenerTodasSolicitudes(){
        return solicitudCreditoRepository.findAll();
    }
    
    public SolicitudCredito obtenerSolicitudById(Long solicitudId){
        return solicitudCreditoRepository.findById(solicitudId).orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }
    
    
    public List<SolicitudCredito> obtenerSolicitudesByEstado(String estado){
        return solicitudCreditoRepository.findByEstado(estado);
    }
    
  
   
    
    

}
