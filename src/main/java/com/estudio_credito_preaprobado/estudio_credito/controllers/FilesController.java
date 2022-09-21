package com.estudio_credito_preaprobado.estudio_credito.controllers;

import com.estudio_credito_preaprobado.estudio_credito.payload.response.MessageResponse;
import com.estudio_credito_preaprobado.estudio_credito.services.CustomMultipartFile;
import com.estudio_credito_preaprobado.estudio_credito.services.FileService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/files")
public class FilesController {

    
     @Autowired
    private FileService archivoService;
    
    
    @PostMapping("/picture")
    public ResponseEntity<MessageResponse> SubirFoto(@RequestBody String base64) throws FileNotFoundException, IOException, Exception {

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
        
        List<MultipartFile> files = new ArrayList<>();
        files.add(multipartFile);
        save(files);

        return ResponseEntity.ok(new MessageResponse("archivos cargados"));
    }
    
    
    public void save(List<MultipartFile>files) throws Exception{
        archivoService.save(files);
    }

}
