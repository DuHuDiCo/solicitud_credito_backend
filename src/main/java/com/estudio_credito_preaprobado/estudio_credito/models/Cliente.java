
package com.estudio_credito_preaprobado.estudio_credito.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class Cliente  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
  
    @Size(max = 100)    
    private String nombres;
    
    
    @Size(max = 100)
    private String apellidos;
    
    
    @Size(max = 20)
    private String cedula;
    
   
    
    @Size(max = 10)
    private String estado_civil;
    
   
    
    @Size(max = 100)
    private String direccion;
    
    
    
    
    @Size(max = 20)
    private String celular;
    
    
    
    @Size(max = 50)
    private String email;
    
    
    
    @Size(max = 50)
    private String empresa;
    
    @Size(max = 50)
    private String direccion_empresa;
    
    
    
    @Size(max = 30)
    private String cargo;
    
    
    
    @Size(max = 50)
    private String tiempo_servicio;
    
    
    private float salario;
    
    
    private String otros_ingresos;
    
    @Size(max = 20)
    private String tipo_casa;
    
    
    private float valor_alquiler;
    
    
    @Size(max = 100)
    private String propietario;
    
    
    @Size(max = 50)
    private String telefono_casa;
    
    @Size(max = 150)
    private String nombre_conyuge;
    
    @Size(max = 50)
    private String trabajo_conyuge;
    
    @Size(max = 100)
    private String direccion_trabajo_conyuge;
    
    @Size(max = 50)
    private String telefono_trabajo_conyuge;
    
    @Size(max = 100)
    private String nombre_pariente;
    
    @Size(max = 50)
    private String direccion_pariente;
    
    @Size(max = 20)
    private String telefono_pariente;
    
    
    private float valor_otros_ingresos;
    
    @ManyToMany( fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "cliente_referencias_comerciales", joinColumns =  @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "referencias_comerciales_id"))
    private List<ReferenciasComerciales> referencias_comerciales = new ArrayList<>();
    
    
    @ManyToMany(fetch = FetchType.LAZY, cascade  = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "cliente_referencias_personales", joinColumns =  @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "referencias_personales_id"))
    private List<ReferenciasPersonales> referencias_personales = new ArrayList<>();
    
    
    

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cedula_id", referencedColumnName = "id")
    private CedulaCiudadaniaCliente cedula_ciudadania_cliente;

    
    public Cliente() {
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

    public CedulaCiudadaniaCliente getCedula_ciudadania_cliente() {
        return cedula_ciudadania_cliente;
    }

    public void setCedula_ciudadania_cliente(CedulaCiudadaniaCliente cedula_ciudadania_cliente) {
        this.cedula_ciudadania_cliente = cedula_ciudadania_cliente;
    }

    
    
    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public float getValor_otros_ingresos() {
        return valor_otros_ingresos;
    }

    public void setValor_otros_ingresos(float valor_otros_ingresos) {
        this.valor_otros_ingresos = valor_otros_ingresos;
    }

    public List<ReferenciasComerciales> getReferencias_comerciales() {
        return referencias_comerciales;
    }

    public void setReferencias_comerciales(List<ReferenciasComerciales> referencias_comerciales) {
        this.referencias_comerciales = referencias_comerciales;
    }

    public List<ReferenciasPersonales> getReferencias_personales() {
        return referencias_personales;
    }

    public void setReferencias_personales(List<ReferenciasPersonales> referencias_personales) {
        this.referencias_personales = referencias_personales;
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

    public float getValor_alquiler() {
        return valor_alquiler;
    }

    public void setValor_alquiler(float valor_alquiler) {
        this.valor_alquiler = valor_alquiler;
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
