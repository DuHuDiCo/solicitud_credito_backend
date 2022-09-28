
package com.estudio_credito_preaprobado.estudio_credito.controllers;

import com.estudio_credito_preaprobado.estudio_credito.DTOS.SolicitudCreditoAllDTO;
import com.estudio_credito_preaprobado.estudio_credito.models.Archivo;
import com.estudio_credito_preaprobado.estudio_credito.models.CedulaCiudadaniaCliente;
import com.estudio_credito_preaprobado.estudio_credito.models.CedulaCiudadaniaCodeudor;
import com.estudio_credito_preaprobado.estudio_credito.models.Foto;
import com.estudio_credito_preaprobado.estudio_credito.models.SolicitudCredito;
import com.estudio_credito_preaprobado.estudio_credito.payload.response.SolicitudCreditoResponse;
import com.estudio_credito_preaprobado.estudio_credito.services.SolicitudCreditoService;
import com.estudio_credito_preaprobado.estudio_credito.utils.Funciones;
import com.estudio_credito_preaprobado.estudio_credito.utils.SaveFIles;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/analista")
public class SolicitudCreditoAnalistaController {
    
    
    @Autowired
    private SolicitudCreditoService creditoService;
    
    @Autowired
    private SaveFIles Sfiles;
    
    @GetMapping("/")
    public ResponseEntity<?> obtenerSolicitudes()  throws FileNotFoundException{
        List<SolicitudCredito> solicitudes = creditoService.obtenerSolicitudesByEstado("EN ESTUDIO");
        List<SolicitudCreditoAllDTO> response = new ArrayList<>();
       
        solicitudes.forEach(sol->{
            try {
           
                //-----------------------------------------CONVERTIR A LA RESPUESTA------------------------------
                String nombreCliente = sol.getCliente().getNombres() +" "+sol.getCliente().getApellidos();
                String fecha = Funciones.dateToString(sol.getFecha());
                
                ModelMapper mp = new ModelMapper();
                SolicitudCreditoAllDTO solicitudResponse = mp.map(sol, SolicitudCreditoAllDTO.class);
                solicitudResponse.setFecha(fecha);
                solicitudResponse.setCliente(nombreCliente);
                response.add(solicitudResponse);
                
            } catch (ParseException ex) {
                Logger.getLogger(SolicitudCreditoAnalistaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        return ResponseEntity.ok(response);
    }
    
    
    @GetMapping("/{solicitudId}")
    public ResponseEntity<?> obtenerSolicitudById(@PathVariable("solicitudId") Long solicitudId) throws IOException, ParseException{
        SolicitudCredito sc = creditoService.obtenerSolicitudById(solicitudId);
        
        CedulaCiudadaniaCliente cedCli = Sfiles.cedulaClienteToBase64(sc.getCliente().getCedula_ciudadania_cliente());
        sc.getCliente().setCedula_ciudadania_cliente(cedCli);
        
        CedulaCiudadaniaCodeudor cedCod = Sfiles.cedulaCodeudorToBase64(sc.getCodeudor().getCedula_ciudadania_codeudor());
        sc.getCodeudor().setCedula_ciudadania_codeudor(cedCod);
        
        Foto foto = Sfiles.fotoToBase64(sc.getDocumentos().getFoto());
        sc.getDocumentos().setFoto(foto);
        
        ModelMapper mp = new ModelMapper();
        SolicitudCreditoResponse response = mp.map(sc, SolicitudCreditoResponse.class);
        response.setFecha(Funciones.dateToString(sc.getFecha()));
        
        
        return ResponseEntity.ok(response);
    }
    
    

}
