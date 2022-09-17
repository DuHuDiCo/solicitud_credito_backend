
package com.estudio_credito_preaprobado.estudio_credito.services;

import com.estudio_credito_preaprobado.estudio_credito.models.Venta;
import com.estudio_credito_preaprobado.estudio_credito.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    
    
    @Autowired
    private VentaRepository ventaRepository;
    
    
    public Venta guardarVenta(Venta venta){
        return ventaRepository.save(venta);
    }

}
