
package com.estudio_credito_preaprobado.estudio_credito.controllers;

import com.estudio_credito_preaprobado.estudio_credito.models.SolicitudCredito;
import com.estudio_credito_preaprobado.estudio_credito.models.Venta;
import com.estudio_credito_preaprobado.estudio_credito.payload.response.MessageResponse;
import com.estudio_credito_preaprobado.estudio_credito.services.SolicitudCreditoService;
import com.estudio_credito_preaprobado.estudio_credito.services.VentaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/solicitud-vendedor")
public class SolicitudCreditoVendedorController {
    
    
    @Autowired
    private SolicitudCreditoService solicitudCreditoService;
    
    @Autowired
    private VentaService ventaService;
    
    
    
    @PostMapping("/")
    public ResponseEntity<?> crearNuevaSolicitudCreditoVendedor(@RequestBody List<Venta> solicitud){
       
        
        List<Venta> ventas = new ArrayList<>();
        System.out.println(solicitud.size());
        
        
        solicitud.forEach(vent ->{
            Venta venta = new Venta();
            venta.setReferencia(vent.getReferencia());
            venta.setProducto(vent.getProducto());
            venta.setPago_inicial(vent.getPago_inicial());
            venta.setCuotas(vent.getCuotas());
            venta.setValor_producto(vent.getValor_producto());
            Venta send = ventaService.guardarVenta(venta);
            ventas.add(send);
        });
        System.out.println(ventas.size());
        SolicitudCredito sc = new SolicitudCredito();
        sc.setVentas(ventas);
        sc.setEstado("CREADO");
        
        return ResponseEntity.ok(solicitudCreditoService.crearSolicitudCredito(sc));
    }
    
    
    @GetMapping("/all")
    public List<SolicitudCredito> obtenerTodasSolicitudes(){
        
        return solicitudCreditoService.obtenerSolicitudesByEstado("CREADO");
    }
    
    
    @GetMapping("/{solicitudId}")
    public ResponseEntity<?> eliminarSolicitudCredito(@PathVariable("solicitudId") Long solicitudId){
        SolicitudCredito sc = solicitudCreditoService.obtenerSolicitudById(solicitudId);
        sc.setEstado("CANCELADO");
        SolicitudCredito scActu = solicitudCreditoService.crearSolicitudCredito(sc);
        return ResponseEntity.ok(new MessageResponse("Solicitud Eliminada"));
    }
    
    
    

}
