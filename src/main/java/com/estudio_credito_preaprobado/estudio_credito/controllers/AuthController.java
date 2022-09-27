package com.estudio_credito_preaprobado.estudio_credito.controllers;

import com.estudio_credito_preaprobado.estudio_credito.DTOS.UsuarioDto;
import com.estudio_credito_preaprobado.estudio_credito.models.ERol;
import com.estudio_credito_preaprobado.estudio_credito.models.Rol;
import com.estudio_credito_preaprobado.estudio_credito.models.Usuario;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.LoginRequest;
import com.estudio_credito_preaprobado.estudio_credito.payload.request.RegistroRequest;
import com.estudio_credito_preaprobado.estudio_credito.payload.response.JwtResponse;
import com.estudio_credito_preaprobado.estudio_credito.payload.response.MessageResponse;
import com.estudio_credito_preaprobado.estudio_credito.repository.RolRepository;
import com.estudio_credito_preaprobado.estudio_credito.repository.UsuarioRepository;
import com.estudio_credito_preaprobado.estudio_credito.security.jwt.JwtUtils;
import com.estudio_credito_preaprobado.estudio_credito.security.service.UserDetailsImpl;
import com.estudio_credito_preaprobado.estudio_credito.security.service.UserDetailsServiceImpl;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest login) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetailsImpl.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetailsImpl.getId(), userDetailsImpl.getUsername(), userDetailsImpl.getEmail(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistroRequest registro) {
        if (usuarioRepository.existsByUsername(registro.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username esta en uso"));
        }

        if (usuarioRepository.existsByEmail(registro.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email esta en uso"));
        }

        //crear usuario nuevo
        Usuario user = new Usuario();
        user.setUsername(registro.getUsername());
        user.setEmail(registro.getEmail());
        user.setPassword(passwordEncoder.encode(registro.getPassword()));

        user.setNombre(registro.getNombre());
        user.setApellido(registro.getApellido());

        Set<String> strRoles = registro.getRoles();
        Set<Rol> roles = new HashSet<>();

        if (strRoles == null) {
            Rol userRol = rolRepository.findByNombre(ERol.ROL_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
            roles.add(userRol);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Rol adminRol = rolRepository.findByNombre(ERol.ROL_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(adminRol);
                        break;
                    case "analista":
                        Rol analistaRol = rolRepository.findByNombre(ERol.ROL_ANALISTA)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(analistaRol);
                        
                        break;
                    case "mod":
                        Rol modRol = rolRepository.findByNombre(ERol.ROL_MODERADOR)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(modRol);
                        break;
                    default:
                        Rol userRol = rolRepository.findByNombre(ERol.ROL_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(userRol);

                }
            });
        }

        user.setRoles(roles);
        usuarioRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("Usuario Registrado Con Exito"));

    }

    @GetMapping("/current")
    public UsuarioDto usuarioActual(Principal principal) {
        Usuario user = (Usuario) userDetailsServiceImpl.loadUserByUsername(principal.getName());
        ModelMapper mapper = new ModelMapper();
        UsuarioDto userDto = mapper.map(user, UsuarioDto.class);
        return userDto;
    }

}
