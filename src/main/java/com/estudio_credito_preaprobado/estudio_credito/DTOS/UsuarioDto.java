
package com.estudio_credito_preaprobado.estudio_credito.DTOS;

import java.util.ArrayList;
import java.util.List;


public class UsuarioDto {
    
    private Long id;
    private String username;
    private String email;
    private String nombre;
    private String apellido;
    private List<RolDto> roles = new ArrayList<>();

    public UsuarioDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<RolDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RolDto> roles) {
        this.roles = roles;
    }
    
    
    
}
