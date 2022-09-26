
package com.estudio_credito_preaprobado.estudio_credito.controllers;

import com.estudio_credito_preaprobado.estudio_credito.models.Archivo;
import com.estudio_credito_preaprobado.estudio_credito.models.CedulaCiudadania;
import com.estudio_credito_preaprobado.estudio_credito.models.DataCredito;
import com.estudio_credito_preaprobado.estudio_credito.models.DatosPersonales;
import com.estudio_credito_preaprobado.estudio_credito.models.Documentos;
import com.estudio_credito_preaprobado.estudio_credito.models.Foto;
import com.estudio_credito_preaprobado.estudio_credito.models.ReferenciasComerciales;
import com.estudio_credito_preaprobado.estudio_credito.models.SolicitudCredito;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.CedulaRequest;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.DocumentosRequest;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.ReferenciasComercialesRequest;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.SolicitudCreditoClienteRequest;
import com.estudio_credito_preaprobado.estudio_credito.services.SolicitudCreditoService;
import com.estudio_credito_preaprobado.estudio_credito.utils.Funciones;
import com.estudio_credito_preaprobado.estudio_credito.utils.SaveFIles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
@RestController
@RequestMapping("/api/solicitud-cliente")
public class SolicitudCreditoClienteController {
    
    
    @Autowired
    private SolicitudCreditoService solicitudCreditoService;
    
    @Autowired
    private SaveFIles Sfiles;
    
    @PostMapping("/")
    public ResponseEntity<?> crearSolicitudCreditoCliente(@RequestBody SolicitudCreditoClienteRequest solicitudCredito) throws Exception{
          
        //recuperamos la solicitud de credito creada poor el vendedor
        SolicitudCredito solicitud = solicitudCreditoService.obtenerSolicitudById(solicitudCredito.getId());
        // a esa solicitud recuperada le enviamos los datos del cliente 
        solicitud.setCliente(solicitudCredito.getCliente());
        //le enviamos los datos del codeudor
        solicitud.setCodeudor(solicitudCredito.getCodeudor());
//        
        //obtenemos los documentos enviados en la peticion
        DocumentosRequest docR = solicitudCredito.getDocumentos();
        //obtenemos la cedula del comprador
        CedulaRequest cdcom = docR.getCedula_ciudadania_comprador();
        //guardamos la cedula del comprador
        Archivo frente_cedula_comprador = Sfiles.guardarCedula(cdcom.getFrente_cedula());
        Archivo respaldo_cedula_comprador = Sfiles.guardarCedula(cdcom.getRespaldo_cedula());
        //obtenemos la cedula del codeudor
        CedulaRequest cdcod = docR.getCedula_ciudadania_codeudor();
        //guardamos la cedula del codeudor
        Archivo frente_cedula_codeudor = Sfiles.guardarCedula(cdcod.getFrente_cedula());
        Archivo respaldo_cedula_codeudor = Sfiles.guardarCedula(cdcod.getRespaldo_cedula());
        
        //creamos las nuevas cedulas para la base de datos
        CedulaCiudadania cedula_comprador = new CedulaCiudadania();
        cedula_comprador.setFrenteCedula(frente_cedula_comprador.getRuta());
        cedula_comprador.setRespaldoCedula(respaldo_cedula_comprador.getRuta());
        
        CedulaCiudadania cedula_codeudor = new CedulaCiudadania();
        cedula_codeudor.setFrenteCedula(frente_cedula_codeudor.getRuta());
        cedula_codeudor.setRespaldoCedula(respaldo_cedula_codeudor.getRuta());
        
        //agregamos las cedulas la lista de cedulas
        Set<CedulaCiudadania> cedulas = new HashSet<>();
        cedulas.add(cedula_comprador);
        cedulas.add(cedula_codeudor);
        
        //guardamos la foto del comprador 
        Foto foto = docR.getFoto();
        Archivo foto_converted = Sfiles.guardarCedula(foto.getFoto());
        Foto newFoto = new Foto();
        newFoto.setFoto(foto_converted.getRuta());
        
        //creamos el nuevo conjunto de documentos para la solicitud
        Documentos docsNuevos = new Documentos();
        docsNuevos.setCedulasCiudadania(cedulas);
        DataCredito dc = docR.getDataCredito();
        dc.setFecha(Funciones.obtenerLocalDateTime());
        docsNuevos.setDataCredito(dc);
        DatosPersonales dp = docR.getDatosPersonales();
        dp.setFecha(Funciones.obtenerLocalDateTime());
        docsNuevos.setDatosPersonales(dp);
        docsNuevos.setFoto(newFoto);
        
        //enviamos el nuevo conjunto de documentos a la solicitud recuperada
        solicitud.setDocumentos(docsNuevos);
        
        //obtenemos las referencias comerciales del comprador
        ReferenciasComercialesRequest rcr = solicitudCredito.getReferencias_comerciales();
        List<ReferenciasComerciales> referencias_comprador = rcr.getReferencias_comerciales_comprador();
        List<ReferenciasComerciales> referencias_codeudor = rcr.getReferencias_comerciales_codeudor();
        List<ReferenciasComerciales> referencias_comerciales = new ArrayList<>();
        referencias_comprador.forEach(rc -> {
            referencias_comerciales.add(rc);
        });
        
        
       
       
        
        
        return ResponseEntity.ok(solicitudCredito);
    }

}
