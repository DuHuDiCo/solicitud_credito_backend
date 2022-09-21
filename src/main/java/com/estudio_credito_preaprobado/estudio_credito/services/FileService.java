
package com.estudio_credito_preaprobado.estudio_credito.services;


import com.estudio_credito_preaprobado.estudio_credito.models.Archivo;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {
    
    public void save(MultipartFile file) throws Exception;
    
    public Resource load(String name) throws Exception;
    
    public void save(List<MultipartFile> file) throws Exception;
    
    public Stream<Path> loadAll() throws Exception;
    
    public Archivo save(Archivo file);
   
    
}
