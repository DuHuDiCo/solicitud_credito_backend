
package com.estudio_credito_preaprobado.estudio_credito.payload.request;

import java.util.HashSet;
import java.util.Set;


public class RegistroRequest {
    
    
    private Long id;
  
    private String username;
   
    private String email;
   
    private String password;
    
    private String nombre;
    
    private String apellido;
    
    private Set<String> roles = new HashSet<>();

    public RegistroRequest() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
    

}
