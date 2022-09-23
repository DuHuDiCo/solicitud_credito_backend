
package com.estudio_credito_preaprobado.estudio_credito.controllers;

import com.estudio_credito_preaprobado.estudio_credito.models.Archivo;
import com.estudio_credito_preaprobado.estudio_credito.models.CedulaCiudadania;
import com.estudio_credito_preaprobado.estudio_credito.models.DataCredito;
import com.estudio_credito_preaprobado.estudio_credito.models.Documentos;
import com.estudio_credito_preaprobado.estudio_credito.models.Foto;
import com.estudio_credito_preaprobado.estudio_credito.models.Referencias;
import com.estudio_credito_preaprobado.estudio_credito.models.SolicitudCredito;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.SolicitudCreditoClienteRequest;
import com.estudio_credito_preaprobado.estudio_credito.services.SolicitudCreditoService;
import com.estudio_credito_preaprobado.estudio_credito.utils.Funciones;
import com.estudio_credito_preaprobado.estudio_credito.utils.SaveFIles;
import java.util.HashSet;
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
    public ResponseEntity<SolicitudCredito> crearSolicitudCreditoCliente(@RequestBody SolicitudCreditoClienteRequest solicitudCredito) throws Exception{
        //recuperamos la solicitud de credito creada poor el vendedor
        SolicitudCredito solicitud = solicitudCreditoService.obtenerSolicitudById(solicitudCredito.getId());
        // a esa solicitud recuperada le enviamos los datos del cliente 
        solicitud.setCliente(solicitudCredito.getCliente());
        //le enviamos los datos del codeudor
        solicitud.setCodeudor(solicitudCredito.getCodeudor());
        
        //obtenemos los documentos enviados en la peticion
        Documentos doc  = solicitudCredito.getDocumentos();
        //obtenemos las cedulas en el conjunto de documentos de la peticion
        Set<CedulaCiudadania> cds = doc.getCedulasCiudadania();
        //creamos una lista de cedulas a la cual le agregarmeos la ruta del archivo ya guardado
        Set<CedulaCiudadania> cedulas = new HashSet<>();
        
        //recorremos las cedulas de ciudadanias de la peticion
        for(CedulaCiudadania c : cds){
            //guardamos el frente de la cedula en la ruta especificada
            Archivo frente = Sfiles.guardarCedula(c.getFrenteCedula());
            //guardamos el respaldo de la cedula en la ruta especificada
            Archivo respaldo = Sfiles.guardarCedula(c.getRespaldoCedula());
            //guardamos las rutas de cada archivo en un objeto nuevo y lo agregamos a la lista de cedulas nuevas
            CedulaCiudadania cd = new CedulaCiudadania();
            cd.setFrenteCedula(frente.getRuta());
            cd.setRespaldoCedula(respaldo.getRuta());
            cd.setPropietario(c.getPropietario());
            cedulas.add(cd);
            
        }
        
        //obtenemos la foto del cliente y la guardamos en la ruta especificada
        Archivo foto = Sfiles.guardarCedula(doc.getFoto().getFoto());
        //guardamos la ruta en un nuevo objeto para asignarlo a un nuevo conjunto de documentos
        Foto f = new Foto();
        f.setFoto(foto.getRuta());
        
        
        //creamos un nuevo conjunto de documentos con las imagenes del frente y respalde de la cedula
        //la foto del cliente ya guardadas en el servidor y obteniendo la ruta de cada archivo
        Documentos nuevos = new Documentos();
        nuevos.setCedulasCiudadania(cedulas);
        DataCredito dc = doc.getDataCredito();
        dc.setFecha(Funciones.obtenerLocalDateTime());
        nuevos.setDatosPersonales(doc.getDatosPersonales());
        nuevos.setFoto(f);
        
        //enviamos ese conjunto de documentos a la solicitud recuperada
        solicitud.setDocumentos(nuevos);
        
        //recuperamos las referencias que llegan en la peticion
        Referencias ref = solicitudCredito.getReferencias();
        //recuperamos las referencias comerciales de el conjunto de referencias y las agremamos a la solicitud creada
        solicitud.setReferenciasComerciales(ref.getReferenciasComercialeses());
        solicitud.setReferenciasPersonales(ref.getReferenciasPersonaleses());
        
       
        //guardamos en la base de datos esa solicitud de credito
        SolicitudCredito response = solicitudCreditoService.crearSolicitudCredito(solicitud);
        
        
        return ResponseEntity.ok(response);
    }

}
