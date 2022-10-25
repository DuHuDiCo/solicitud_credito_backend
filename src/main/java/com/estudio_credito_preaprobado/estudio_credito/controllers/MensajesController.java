
package com.estudio_credito_preaprobado.estudio_credito.controllers;

import com.estudio_credito_preaprobado.estudio_credito.models.Mensaje;
import com.estudio_credito_preaprobado.estudio_credito.payload.response.MensajeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/mensajes")
public class MensajesController {
    
    private static final String URL_BASE = "https://api-sms.masivapp.com";
    
    
    @PostMapping("/send-message")
    public ResponseEntity<?> enviarMensaje(@RequestBody Mensaje mensaje){
        RestTemplate restTemplate = new RestTemplate();
        MensajeResponse mensajeResponse = restTemplate.postForObject(URL_BASE, mensaje, MensajeResponse.class);
        return ResponseEntity.ok(mensajeResponse);
    }

}
