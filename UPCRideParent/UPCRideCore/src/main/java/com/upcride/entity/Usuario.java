/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author sebas
 */
@Entity
@Table (name= "Usuario")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @Column (name = "codigo", length = 10, nullable = false)  
    private String codigo;
     
    @Column (name = "nombres", length = 60, nullable = false) 
    private String nombres;
    
    @Column (name = "apellidos", length = 60, nullable = true) 
    private String apellidos;
    
    @Column (name = "email", length = 50, nullable = false)     
    private String email;
    
    @Column (name = "contrasena", length = 40, nullable = false)     
    private String contrasena;
  
    @Column (name = "ubicacion", length = 250, nullable = false) 
    private String ubicacion;
    
    @Column (name = "facebookID", length = 60, nullable = true) 
    private String facebookID;
    
    @Column (name = "telefono", length = 25, nullable = true) 
    private String telefono;
    
    @ManyToOne
    @JoinColumn (name = "codigoDistrito") 
    private Distrito Distrito;
    
    @Column (name = "rol") 
    private int rol;
    
    @Column (name = "licenciaConducir", length = 9, nullable = true) 
    private String licenciaConducir;       
    
    @OneToOne
    @JoinColumn(name = "placaAuto", nullable = true)
    private Auto auto;
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getLicenciaConducir() {
        return licenciaConducir;
    }

    public void setLicenciaConducir(String licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }

    public Distrito getDistrito() {
        return Distrito;
    }

    public void setDistrito(Distrito Distrito) {
        this.Distrito = Distrito;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
    
    
}