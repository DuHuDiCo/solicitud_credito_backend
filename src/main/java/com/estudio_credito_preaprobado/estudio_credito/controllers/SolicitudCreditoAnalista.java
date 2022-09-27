
package com.estudio_credito_preaprobado.estudio_credito.controllers;

import com.estudio_credito_preaprobado.estudio_credito.models.Archivo;
import com.estudio_credito_preaprobado.estudio_credito.models.SolicitudCredito;
import com.estudio_credito_preaprobado.estudio_credito.services.SolicitudCreditoService;
import com.estudio_credito_preaprobado.estudio_credito.utils.Funciones;
import com.estudio_credito_preaprobado.estudio_credito.utils.SaveFIles;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/analista")
public class SolicitudCreditoAnalista {
    
    
    @Autowired
    private SolicitudCreditoService creditoService;
    
    @Autowired
    private SaveFIles Sfiles;
    
    @GetMapping("/")
    public ResponseEntity<?> obtenerSolicitudes()  throws FileNotFoundException{
        List<SolicitudCredito> solicitudes = creditoService.obtenerSolicitudesByEstado("EN ESTUDIO");
        String ruta = "J:\\Duvan Humberto Diaz Contreras\\ElectroHogar\\solicitud_credito_backend\\uploads\\";
        solicitudes.forEach(sol->{
            try {
                
                //--------------------------CLIENTE CEDULA----------------------------------------
                String frente_cliente = ruta+sol.getCliente().getCedula_ciudadania_cliente().getFrente_cedula();
                Archivo file_frente_cliente = Sfiles.imagenToBase64(frente_cliente);
                sol.getCliente().getCedula_ciudadania_cliente().setFrente_cedula(file_frente_cliente.getRuta());
                
                String respaldo_cliente = ruta+sol.getCliente().getCedula_ciudadania_cliente().getRespaldo_cedula();
                Archivo file_respaldo_cliente = Sfiles.imagenToBase64(respaldo_cliente);
                sol.getCliente().getCedula_ciudadania_cliente().setRespaldo_cedula(file_respaldo_cliente.getRuta());
                
                //--------------------------------------------CODEUDOR CEDULA----------------------------------
                
                String frente_codeudor = ruta + sol.getCodeudor().getCedula_ciudadania_codeudor().getFrente_cedula();
                Archivo file_frente_codeudor = Sfiles.imagenToBase64(frente_codeudor);
                sol.getCodeudor().getCedula_ciudadania_codeudor().setFrente_cedula(file_frente_codeudor.getRuta());
                
                
                String respaldo_codeudor = ruta + sol.getCodeudor().getCedula_ciudadania_codeudor().getRespaldo_cedula();
                Archivo file_respaldo_codeudor = Sfiles.imagenToBase64(respaldo_codeudor);
                sol.getCodeudor().getCedula_ciudadania_codeudor().setRespaldo_cedula(file_respaldo_codeudor.getRuta());
                
                //------------------------------------------FOTO-----------------------------
                String foto = ruta + sol.getDocumentos().getFoto().getFoto();
                Archivo photo = Sfiles.imagenToBase64(foto);
                sol.getDocumentos().getFoto().setFoto(photo.getRuta());
                
            } catch (IOException ex) {
                Logger.getLogger(SolicitudCreditoAnalista.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        return ResponseEntity.ok(solicitudes);
    }

}
