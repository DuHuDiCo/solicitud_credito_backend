package com.estudio_credito_preaprobado.estudio_credito.utils;

import com.estudio_credito_preaprobado.estudio_credito.models.Archivo;
import com.estudio_credito_preaprobado.estudio_credito.models.CedulaCiudadaniaCliente;
import com.estudio_credito_preaprobado.estudio_credito.models.CedulaCiudadaniaCodeudor;
import com.estudio_credito_preaprobado.estudio_credito.models.Foto;
import com.estudio_credito_preaprobado.estudio_credito.services.CustomMultipartFile;
import com.estudio_credito_preaprobado.estudio_credito.services.FileService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SaveFIles {

    @Autowired
    private FileService fileService;
    
    private static  final String  ruta = "J:\\Duvan Humberto Diaz Contreras\\ElectroHogar\\solicitud_credito_backend\\uploads\\";

    public Archivo guardarCedula(String base64) throws Exception {

        final String[] base64Array = base64.split(",");

        String dataUir, data;

        if (base64Array.length > 1) {
            dataUir = base64Array[0];
            data = base64Array[1];
        } else {
            dataUir = "data:image/jpg;base64";
            data = base64Array[0];
        }

        MultipartFile multipartFile = new CustomMultipartFile(data, dataUir);
        String name = fileService.save(multipartFile);

        Archivo file = new Archivo();
        file.setNombre(name);

        file.setFecha(Funciones.obtenerDate());

        Resource f = fileService.load(file.getNombre());

        String url = f.getFilename();
        file.setRuta(url);

        return file;

    }

    public Archivo imagenToBase64(String ruta) throws FileNotFoundException, IOException {
        File img = new File(ruta);
        Base64 base64 = new Base64();
        byte[] imageBytes = new byte[(int) img.length()];
        InputStream inputStream = new FileInputStream(img);
        inputStream.read(imageBytes);
        String encodedFile = base64.encodeToString(imageBytes);
        Archivo file = new Archivo();
        file.setNombre(img.getName());
        file.setRuta(encodedFile);

        return file;
    }

    public CedulaCiudadaniaCliente cedulaClienteToBase64(CedulaCiudadaniaCliente cedula) throws IOException {
        
        String frente_cliente = ruta + cedula.getFrente_cedula();
        Archivo file_frente_cliente = imagenToBase64(frente_cliente);
        cedula.setFrente_cedula(file_frente_cliente.getRuta());

        String respaldo_cliente = ruta + cedula.getRespaldo_cedula();
        Archivo file_respaldo_cliente = imagenToBase64(respaldo_cliente);
        cedula.setRespaldo_cedula(file_respaldo_cliente.getRuta());
        return cedula;
    }
    
    public CedulaCiudadaniaCodeudor cedulaCodeudorToBase64(CedulaCiudadaniaCodeudor cedula) throws IOException {
        
        String frente_codeudor = ruta + cedula.getFrente_cedula();
        Archivo file_frente_codeudor= imagenToBase64(frente_codeudor);
        cedula.setFrente_cedula(file_frente_codeudor.getRuta());

        String respaldo_codeudor = ruta + cedula.getRespaldo_cedula();
        Archivo file_respaldo_codeudor = imagenToBase64(respaldo_codeudor);
        cedula.setRespaldo_cedula(file_respaldo_codeudor.getRuta());
        return cedula;
    }
    
    public Foto fotoToBase64(Foto foto) throws IOException{
        String photo = ruta + foto.getFoto();
        Archivo file_foto = imagenToBase64(photo);
        foto.setFoto(file_foto.getRuta());
        return foto;
    }

}
