package com.estudio_credito_preaprobado.estudio_credito.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Codeudor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 100)
    private String nombres;
    
    @Size(max = 100)
    private String apellidos;
    
    @Size(max = 20)
    private String cedula;
    
    @Size(max = 50)
    private String estado_civil;
    
    @Size(max = 100)
    private String direccion;
    
    @Size(max = 30)
    private String telefono;
    
    @Size(max = 20)
    private String celular;
    
    @Size(max = 100)
    private String email;
    
    @Size(max = 50)
    private String empresa;
    
    @Size(max = 30)
    private String cargo;
    
    @Size(max = 30)
    private String tiempo_servicio;
    
    private float salario;
    
    
    private String otros_ingresos;
    
    @Size(max = 30)
    private String tipo_casa;
    
    @Size(max = 100)
    private String propietario;
    
    @Size(max = 100)
    private String direccion_casa;
    
    @Size(max = 30)
    private String telefono_casa;
    
    @Size(max = 100)
    private String nombre_conyuge;
    
    @Size(max = 100)
    private String trabajo_conyuge;
    
    @Size(max = 100)
    private String direccion_trabajo_conyuge;
    
    @Size(max = 50)
    private String telefono_trabajo_conyuge;
    
    @Size(max = 100)
    private String nombre_pariente;
    
    @Size(max = 100)
    private String direccion_pariente;
    
    @Size(max = 30)
    private String telefono_pariente;

    public Codeudor() {
    }

    public Codeudor(String nombres, String apellidos, String cedula, String estado_civil, String direccion, String telefono, String celular, String email, String empresa, String cargo, String tiempo_servicio, float salario, String otros_ingresos, String tipo_casa, String propietario, String direccion_casa, String telefono_casa, String nombre_conyuge, String trabajo_conyuge, String direccion_trabajo_conyuge, String telefono_trabajo_conyuge, String nombre_pariente, String direccion_pariente, String telefono_pariente) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.estado_civil = estado_civil;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.empresa = empresa;
        this.cargo = cargo;
        this.tiempo_servicio = tiempo_servicio;
        this.salario = salario;
        this.otros_ingresos = otros_ingresos;
        this.tipo_casa = tipo_casa;
        this.propietario = propietario;
        this.direccion_casa = direccion_casa;
        this.telefono_casa = telefono_casa;
        this.nombre_conyuge = nombre_conyuge;
        this.trabajo_conyuge = trabajo_conyuge;
        this.direccion_trabajo_conyuge = direccion_trabajo_conyuge;
        this.telefono_trabajo_conyuge = telefono_trabajo_conyuge;
        this.nombre_pariente = nombre_pariente;
        this.direccion_pariente = direccion_pariente;
        this.telefono_pariente = telefono_pariente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTiempo_servicio() {
        return tiempo_servicio;
    }

    public void setTiempo_servicio(String tiempo_servicio) {
        this.tiempo_servicio = tiempo_servicio;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getOtros_ingresos() {
        return otros_ingresos;
    }

    public void setOtros_ingresos(String otros_ingresos) {
        this.otros_ingresos = otros_ingresos;
    }

    public String getTipo_casa() {
        return tipo_casa;
    }

    public void setTipo_casa(String tipo_casa) {
        this.tipo_casa = tipo_casa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDireccion_casa() {
        return direccion_casa;
    }

    public void setDireccion_casa(String direccion_casa) {
        this.direccion_casa = direccion_casa;
    }

    public String getTelefono_casa() {
        return telefono_casa;
    }

    public void setTelefono_casa(String telefono_casa) {
        this.telefono_casa = telefono_casa;
    }

    public String getNombre_conyuge() {
        return nombre_conyuge;
    }

    public void setNombre_conyuge(String nombre_conyuge) {
        this.nombre_conyuge = nombre_conyuge;
    }

    public String getTrabajo_conyuge() {
        return trabajo_conyuge;
    }

    public void setTrabajo_conyuge(String trabajo_conyuge) {
        this.trabajo_conyuge = trabajo_conyuge;
    }

    public String getDireccion_trabajo_conyuge() {
        return direccion_trabajo_conyuge;
    }

    public void setDireccion_trabajo_conyuge(String direccion_trabajo_conyuge) {
        this.direccion_trabajo_conyuge = direccion_trabajo_conyuge;
    }

    public String getTelefono_trabajo_conyuge() {
        return telefono_trabajo_conyuge;
    }

    public void setTelefono_trabajo_conyuge(String telefono_trabajo_conyuge) {
        this.telefono_trabajo_conyuge = telefono_trabajo_conyuge;
    }

    public String getNombre_pariente() {
        return nombre_pariente;
    }

    public void setNombre_pariente(String nombre_pariente) {
        this.nombre_pariente = nombre_pariente;
    }

    public String getDireccion_pariente() {
        return direccion_pariente;
    }

    public void setDireccion_pariente(String direccion_pariente) {
        this.direccion_pariente = direccion_pariente;
    }

    public String getTelefono_pariente() {
        return telefono_pariente;
    }

    public void setTelefono_pariente(String telefono_pariente) {
        this.telefono_pariente = telefono_pariente;
    }


    
    
    

}
