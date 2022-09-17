
package com.estudio_credito_preaprobado.estudio_credito.controllers;

import com.estudio_credito_preaprobado.estudio_credito.DTOS.UsuarioDto;
import com.estudio_credito_preaprobado.estudio_credito.models.Usuario;
import com.estudio_credito_preaprobado.estudio_credito.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @GetMapping("/")
    public List<UsuarioDto> getAllUsers(){
        List<Usuario> user = usuarioRepository.findAll();
        List<UsuarioDto> userDto = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        UsuarioDto usuario = null;
        for(Usuario u : user){
            usuario = modelMapper.map(u, UsuarioDto.class);
            userDto.add(usuario);
        }
        
        return userDto;
        
    }
    

}
