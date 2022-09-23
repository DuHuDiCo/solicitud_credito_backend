
package com.estudio_credito_preaprobado.estudio_credito.utils;

import com.estudio_credito_preaprobado.estudio_credito.models.Archivo;
import com.estudio_credito_preaprobado.estudio_credito.services.CustomMultipartFile;
import com.estudio_credito_preaprobado.estudio_credito.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SaveFIles {
    
    
    @Autowired
    private FileService fileService;
    
    
    public Archivo guardarCedula(String base64) throws Exception{
       
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
        fileService.save(multipartFile);
        
        Archivo file = new Archivo();
        file.setNombre(multipartFile.getOriginalFilename());
        
        file.setFecha(Funciones.obtenerDate());
        
        
        
        
        Resource f = fileService.load(file.getNombre());
        
        String url = f.getURI().toString();
        file.setRuta(url);
        
        
        return file;
        
    }

}
