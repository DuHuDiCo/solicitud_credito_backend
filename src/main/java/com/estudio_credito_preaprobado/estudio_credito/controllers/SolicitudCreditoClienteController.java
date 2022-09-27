package com.estudio_credito_preaprobado.estudio_credito.controllers;

import com.estudio_credito_preaprobado.estudio_credito.exceptions.SolicitudNotFoundException;
import com.estudio_credito_preaprobado.estudio_credito.models.Archivo;
import com.estudio_credito_preaprobado.estudio_credito.models.CedulaCiudadaniaCliente;
import com.estudio_credito_preaprobado.estudio_credito.models.CedulaCiudadaniaCodeudor;
import com.estudio_credito_preaprobado.estudio_credito.models.Cliente;
import com.estudio_credito_preaprobado.estudio_credito.models.Codeudor;
import com.estudio_credito_preaprobado.estudio_credito.models.DataCredito;
import com.estudio_credito_preaprobado.estudio_credito.models.DatosPersonales;
import com.estudio_credito_preaprobado.estudio_credito.models.Documentos;
import com.estudio_credito_preaprobado.estudio_credito.models.Foto;
import com.estudio_credito_preaprobado.estudio_credito.models.ReferenciasComerciales;
import com.estudio_credito_preaprobado.estudio_credito.models.ReferenciasPersonales;
import com.estudio_credito_preaprobado.estudio_credito.models.SolicitudCredito;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.DocumentosRequest;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.SolicitudCreditoClienteRequest;
import com.estudio_credito_preaprobado.estudio_credito.services.SolicitudCreditoService;
import com.estudio_credito_preaprobado.estudio_credito.utils.Funciones;
import com.estudio_credito_preaprobado.estudio_credito.utils.SaveFIles;
import java.util.ArrayList;
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
    public ResponseEntity<SolicitudCredito> crearSolicitudCreditoCliente(@RequestBody SolicitudCreditoClienteRequest solicitudCredito) throws Exception, SolicitudNotFoundException {

        //recuperamos la solicitud de credito creada poor el vendedor
        SolicitudCredito solicitud = solicitudCreditoService.obtenerSolicitudById(solicitudCredito.getId());

        //---------CLIENTE--------------
        //recuperamos los datos del cliente
        Cliente cliente = solicitudCredito.getCliente();

        //guardamos la cedula del cliente
        CedulaCiudadaniaCliente cedCli = cliente.getCedula_ciudadania_cliente();
        Archivo frente_cedula_cliente = Sfiles.guardarCedula(cedCli.getFrente_cedula());
        cedCli.setFrente_cedula(frente_cedula_cliente.getRuta());
        Archivo respaldo_cedula__cliente = Sfiles.guardarCedula(cedCli.getRespaldo_cedula());
        cedCli.setRespaldo_cedula(respaldo_cedula__cliente.getRuta());
        //enviamos la cedula ya guardada el cliente recuperado
        cliente.setCedula_ciudadania_cliente(cedCli);
        //enviamos el cliente a la solicitud recuperada
        solicitud.setCliente(cliente);

        //----------CLIENTE REFERENCIAS ----------
        List<ReferenciasComerciales> rcrcom = solicitudCredito.getReferencias_comerciales().getReferencias_comerciales_comprador();
        List<ReferenciasPersonales> rprcom = solicitudCredito.getReferencias_personales().getReferencias_personales_comprador();
        List<ReferenciasComerciales> referencias_comerciles_cliente = new ArrayList<>();
        List<ReferenciasPersonales> referencias_personales_cliente = new ArrayList<>();
        rcrcom.forEach(ref -> {
            ReferenciasComerciales refCom = new ReferenciasComerciales();
            refCom.setNombre(ref.getNombre());
            refCom.setTelefono(ref.getTelefono());
            referencias_comerciles_cliente.add(refCom);
        });
        rprcom.forEach(ref -> {
            ReferenciasPersonales refPer = new ReferenciasPersonales();
            refPer.setNombre(ref.getNombre());
            refPer.setTelefono(ref.getTelefono());
            referencias_personales_cliente.add(refPer);
        });

        //enviamos las referencias al cliente recuperado
        cliente.setReferencias_comerciales(referencias_comerciles_cliente);
        cliente.setReferencias_personales(referencias_personales_cliente);

        //---------CODEUDOR--------------
        Codeudor codeudor = solicitudCredito.getCodeudor();
        //guardamos la cedula del codeudor
        CedulaCiudadaniaCodeudor cedCod = codeudor.getCedula_ciudadania_codeudor();
        Archivo frente_cedula_codeudor = Sfiles.guardarCedula(cedCod.getFrente_cedula());
        cedCod.setFrente_cedula(frente_cedula_codeudor.getNombre());
        Archivo respaldo_cedula_codeudor = Sfiles.guardarCedula(cedCod.getRespaldo_cedula());
        cedCod.setRespaldo_cedula(respaldo_cedula_codeudor.getNombre());
        //enviamos la cedula ya guardada al codeudor recoperado
        codeudor.setCedula_ciudadania_codeudor(cedCod);
        //enviamos el codeudor a la solicitud recuperada
        solicitud.setCodeudor(codeudor);

        //----------CODEUDOR REFERENCIAS----------
        List<ReferenciasComerciales> rcrcod = solicitudCredito.getReferencias_comerciales().getReferencias_comerciales_codeudor();
        List<ReferenciasPersonales> rprcod = solicitudCredito.getReferencias_personales().getReferencias_personales_codeudor();
        Set<ReferenciasComerciales> referencias_comerciles_codeudor = new HashSet<>();
        Set<ReferenciasPersonales> referencias_personales_codeudor = new HashSet<>();
        rcrcod.forEach(ref -> {
            ReferenciasComerciales refCom = new ReferenciasComerciales();
            refCom.setNombre(ref.getNombre());
            refCom.setTelefono(ref.getTelefono());
            referencias_comerciles_codeudor.add(refCom);
        });
        rprcod.forEach(ref -> {
            ReferenciasPersonales refPer = new ReferenciasPersonales();
            refPer.setNombre(ref.getNombre());
            refPer.setTelefono(ref.getTelefono());
            referencias_personales_codeudor.add(refPer);
        });
        
        
        //enviamos las referencias al cliente recuperado
        codeudor.setReferencias_comerciales(referencias_comerciles_codeudor);
        codeudor.setReferencias_personales(referencias_personales_codeudor);

        //--------------------DOCUMENTOS--------------        
        
        //obtenemos los documentos enviados en la peticion
        DocumentosRequest docR = solicitudCredito.getDocumentos();

        //guardamos la foto del comprador 
        Foto foto = docR.getFoto();
        Archivo foto_converted = Sfiles.guardarCedula(foto.getFoto());
        Foto newFoto = new Foto();
        newFoto.setFoto(foto_converted.getNombre());

        //creamos el nuevo conjunto de documentos para la solicitud
        Documentos docsNuevos = new Documentos();

        DataCredito dc = docR.getDataCredito();
        dc.setFecha(Funciones.obtenerLocalDateTime());
        docsNuevos.setDataCredito(dc);
        DatosPersonales dp = docR.getDatosPersonales();
        dp.setFecha(Funciones.obtenerLocalDateTime());
        docsNuevos.setDatosPersonales(dp);
        docsNuevos.setFoto(newFoto);

        //enviamos el nuevo conjunto de documentos a la solicitud recuperada
        solicitud.setDocumentos(docsNuevos);
        
        
        //-------------FECHA SOLICITUD-------------------------------
        solicitud.setFecha(Funciones.obtenerLocalDateTime());
        
        //----------------ESTADO SOLICITUD------------------------
        solicitud.setEstado("EN ESTUDIO");
        

        //--------------GUARDAR BASE DE DATOS--------------------      
        SolicitudCredito sc = solicitudCreditoService.crearSolicitudCredito(solicitud);


        
        return ResponseEntity.ok(sc);

    }

}
