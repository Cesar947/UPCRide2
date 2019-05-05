/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "Solicitud")
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoSolicitud;

    @ManyToOne
    @JoinColumn(name = "codigoCliente")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "codigoViaje")
    private Viaje viaje;

    @Column(name = "mensajeSolicitud", length = 120, nullable = false)
    private String mensaje;

    @Column(name = "confirmacionConductor", nullable = true)
    private int confirmacionConductor;

    @Column(name = "confirmacionCliente", nullable = true)
    private int confirmacionCliente;

    @Column(name = "puntoRecojo", length = 100, nullable = false)
    private String puntoRecojo;

    public int getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(int codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getConfirmacionConductor() {
        return confirmacionConductor;
    }

    public void setConfirmacionConductor(int confirmacionConductor) {
        this.confirmacionConductor = confirmacionConductor;
    }

    public int getConfirmacionCliente() {
        return confirmacionCliente;
    }

    public void setConfirmacionCliente(int confirmacionCliente) {
        this.confirmacionCliente = confirmacionCliente;
    }

    public String getPuntoRecojo() {
        return puntoRecojo;
    }

    public void setPuntoRecojo(String puntoRecojo) {
        this.puntoRecojo = puntoRecojo;
    }

}
