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
import javax.persistence.Table;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "Auto")
public class Auto implements Serializable{

    @Id
    @Column (name="placa", length = 50, nullable = false)
    private String placa;
    
    @Column (name="polizaSoat", length = 50 , nullable = false )
    private int polizaSoat;
    
    @Column (name="marca", length = 50 , nullable = false )
    private String marca;
    
    @Column (name="modelo", length = 50 , nullable = false )
    private String modelo;
    
    @Column (name="limitePersonas", length = 50 , nullable = false )
    private int limitePersonas;
    
    @Column (name="codigoUsuario", length = 50 , nullable = false )
    private Usuario usuario;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    

    
    
    public int getPolizaSoat() {
        return polizaSoat;
    }

    public void setPolizaSoat(int polizaSoat) {
        this.polizaSoat = polizaSoat;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getLimitePersonas() {
        return limitePersonas;
    }

    public void setLimitePersonas(int limitePersonas) {
        this.limitePersonas = limitePersonas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

  

  

 
    
    }

