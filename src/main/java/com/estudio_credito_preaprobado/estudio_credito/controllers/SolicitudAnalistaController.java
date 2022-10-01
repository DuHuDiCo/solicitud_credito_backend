package com.estudio_credito_preaprobado.estudio_credito.controllers;

import com.estudio_credito_preaprobado.estudio_credito.models.AnalisisCredito;
import com.estudio_credito_preaprobado.estudio_credito.models.ReferenciasComerciales;
import com.estudio_credito_preaprobado.estudio_credito.models.ReferenciasPersonales;
import com.estudio_credito_preaprobado.estudio_credito.models.SolicitudCredito;
import com.estudio_credito_preaprobado.estudio_credito.models.Usuario;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.Referencia_Comercial_Cliente;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.Referencia_Comercial_Codeudor;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.Referencia_Personal_Cliente;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.Referencia_Personal_Codeudor;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.ReferenciasComercialesRequest;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.SolicitudAnalistaRequest;
import com.estudio_credito_preaprobado.estudio_credito.payload.response.MessageResponse;
import com.estudio_credito_preaprobado.estudio_credito.repository.UsuarioRepository;
import com.estudio_credito_preaprobado.estudio_credito.services.SolicitudCreditoService;
import com.estudio_credito_preaprobado.estudio_credito.utils.Funciones;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/solicitud-analista")
@RestController
public class SolicitudAnalistaController {

    @Autowired
    private SolicitudCreditoService creditoService;
    
    @Autowired
    private UsuarioRepository  usuarioRepository;

    @PostMapping("/")
    public ResponseEntity<?> guardarAnalisisCredito(@RequestBody SolicitudAnalistaRequest analistaRequest) {
        SolicitudCredito solicitud = creditoService.obtenerSolicitudById(analistaRequest.getId());

        //cliente
        List<Referencia_Comercial_Cliente> sar = analistaRequest.getCliente().getReferencias_comerciales_cliente();
        List<Referencia_Personal_Cliente> sap = analistaRequest.getCliente().getReferencias_personales_cliente();
        
        //codeudor
        List<Referencia_Comercial_Codeudor> rcco = analistaRequest.getCodeudor().getReferencias_comerciales_codeudor();
        List<Referencia_Personal_Codeudor> rpco = analistaRequest.getCodeudor().getReferencias_personales_codeudor();
        
        //--------------------------------solicitud recuperada------------------------------------------

        //cliente
        List<ReferenciasComerciales> refeGuardada = solicitud.getCliente().getReferencias_comerciales();
        List<ReferenciasPersonales> refePerGuar = solicitud.getCliente().getReferencias_personales();
        //codeudor
        List<ReferenciasComerciales> refeGuardadaCod = solicitud.getCodeudor().getReferencias_comerciales();
        List<ReferenciasPersonales> refePerGuardaCod = solicitud.getCodeudor().getReferencias_personales();

        List<ReferenciasComerciales> guardarComClien = new ArrayList<>();
        List<ReferenciasPersonales> guardarPerClien = new ArrayList<>();
        
        List<ReferenciasComerciales> guardarComCode = new ArrayList<>();
        List<ReferenciasPersonales> guardarPerCode = new ArrayList<>();
        
        
        
        
        
        
        
        for (int i = 0; i < refeGuardada.size(); i++) {
            //cliente
            ReferenciasComerciales comer = refeGuardada.get(i);
            Referencia_Comercial_Cliente refe = sar.get(i);
            comer.setReferencia(refe.getObservacion());
            guardarComClien.add(comer);
            
            ReferenciasPersonales perso = refePerGuar.get(i);
            Referencia_Personal_Cliente rpc = sap.get(i);
            perso.setReferencia(rpc.getObservacion());
            guardarPerClien.add(perso);
            
            //codeudor
            ReferenciasComerciales comerCod = refeGuardadaCod.get(i);
            Referencia_Comercial_Codeudor rcc = rcco.get(i);
            comerCod.setReferencia(rcc.getObservacion());
            guardarComCode.add(comerCod);
            
            ReferenciasPersonales persoCod = refePerGuardaCod.get(i);
            Referencia_Personal_Codeudor rpcd = rpco.get(i);
            persoCod.setReferencia(rpcd.getObservacion());
            guardarPerCode.add(persoCod);
        }
        
        //cliente
        solicitud.getCliente().setReferencias_comerciales(refeGuardada);
        solicitud.getCliente().setReferencias_personales(guardarPerClien);
        
        //codeudor
        solicitud.getCodeudor().setReferencias_comerciales(guardarComCode);
        solicitud.getCodeudor().setReferencias_personales(refePerGuardaCod);
        
        Usuario analista = usuarioRepository.findById(analistaRequest.getAnalisis().getUsuario()).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        
        AnalisisCredito analisis = new AnalisisCredito();
        analisis.setObservaciones(analistaRequest.getAnalisis().getObservaciones());
        analisis.setUsuario(analista);
        
        solicitud.setAnalisisCredito(analisis);
        
        solicitud.setEstado(analistaRequest.getEstado());
        
        solicitud.setFecha(Funciones.obtenerLocalDateTime());
        
         
        creditoService.crearSolicitudCredito(solicitud);

        return ResponseEntity.ok(new MessageResponse("Solicitud Credito Actualizada"));
    }

}
