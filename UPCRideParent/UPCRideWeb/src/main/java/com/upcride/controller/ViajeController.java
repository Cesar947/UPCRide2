/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.upcride.business.ViajeBusiness;
import com.upcride.entity.Viaje;
import com.upcride.entity.Usuario;
import com.upcride.business.UsuarioBusiness;

/**
 *
 * @author César Alejandro
 */
@Named
@ViewScoped
public class ViajeController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ViajeBusiness viajeBusiness;

    @Inject
    private UsuarioBusiness conductorBusiness;

    private Viaje viaje;
    private Viaje viajeSeleccionado;
    private List<Viaje> viajes;

    private Usuario conductor;
    private List<Usuario> conductores;

    @PostConstruct
    public void init() {
        viaje = new Viaje();
        viajeSeleccionado = new Viaje();
        conductor = new Usuario();

        this.loadViajes();
        this.loadConductores();
    }

    public void loadConductores() {
        try {
            this.conductores = conductorBusiness.list();
        } catch (Exception ex) {

        }
    }

    public void buscarViajes() {

        try {
            viajes = viajeBusiness.buscarViajes(viaje);
            
            loadViajes();
            cleanForm();
        } catch (Exception e) {

        }
    }
    


    public void loadViajes() {
        try {
            this.viajes = viajeBusiness.list();
        } catch (Exception ex) {

        }
    }

    public void cleanForm() {
        this.viaje = new Viaje();
        this.viajeSeleccionado = null;
    }

    public void saveViaje() {
        try {
            /* if(viaje.getCodigo() != 0){
             viaje.setConductor(conductor);
             viajeBusiness.update(viaje);
             }
             else {*/
            viaje.setConductor(conductor);
            viaje.setVisualizacionHabilitada(1);
            viajeBusiness.insert(viaje);

            loadViajes();
            cleanForm();
        } catch (Exception ex) {

        }
    }

    public void editViaje() {
        try {
            if (this.viaje.getCodigo() > 0) {
                this.viaje = this.viajeSeleccionado;
            } else {

            }
        } catch (Exception ex) {

        }
    }

    public void deleteViaje() {
        try {
            if (this.viajeSeleccionado != null) {
                viajeBusiness.delete(viajeSeleccionado);
                loadViajes();
                cleanForm();
            }
        } catch (Exception ex) {

        }
    }

    public void selectViaje(SelectEvent e) {
        this.viajeSeleccionado = (Viaje) e.getObject();
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    public Viaje getViajeSeleccionado() {
        return viajeSeleccionado;
    }

    public void setViajeSeleccionado(Viaje viajeSeleccionado) {
        this.viajeSeleccionado = viajeSeleccionado;
    }

    public Usuario getConductor() {
        return conductor;
    }

    public void setConductor(Usuario conductor) {
        this.conductor = conductor;
    }

    public List<Usuario> getConductores() {
        return conductores;
    }

    public void setConductores(List<Usuario> conductores) {
        this.conductores = conductores;
    }

}
