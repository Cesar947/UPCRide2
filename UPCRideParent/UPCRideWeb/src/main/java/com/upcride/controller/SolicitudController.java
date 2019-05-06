/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.controller;

import com.upcride.business.SolicitudBusiness;
import com.upcride.business.UsuarioBusiness;
import com.upcride.business.ViajeBusiness;
import com.upcride.entity.Solicitud;
import com.upcride.entity.Usuario;
import com.upcride.entity.Viaje;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author sebas
 */

@Named
@ViewScoped
public class SolicitudController implements Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private SolicitudBusiness solicitudBusiness;
    @Inject
    private ViajeBusiness viajeBusiness;
    @Inject
    private UsuarioBusiness clienteBusiness;

    private Usuario cliente;
    private List<Usuario> clientes;

    private Viaje viaje;
    private List<Viaje> viajes;

    private Solicitud solicitud;
    private Solicitud solicitudSeleccionada;
    private List<Solicitud> solicitudes;

    @PostConstruct
    public void init() {
        solicitud = new Solicitud();
        solicitudSeleccionada = new Solicitud();
        cliente = new Usuario();
        viaje = new Viaje();

        this.loadSolicitudes();
        this.loadClientes();
        this.loadViajes();

    }

    public void loadSolicitudes() {
        try {
            this.solicitudes = solicitudBusiness.list();
        } catch (Exception e) {
        }
    }

    public void loadClientes() {
        try {
            this.clientes = clienteBusiness.list();
        } catch (Exception e) {
        }
    }

    public void loadViajes() {
        try {
            this.viajes = viajeBusiness.list();
        } catch (Exception e) {
        }
    }

    public void saveSolicitud() {
        try {
            solicitud.setConfirmacionConductor(0);
            solicitud.setConfirmacionCliente(0);
            solicitud.setCliente(cliente);
            solicitudBusiness.insert(solicitud);

            loadSolicitudes();
            cleanForm();

        } catch (Exception e) {

        }

    }
    
    public String createSolicitud(int id) throws Exception{
        String resultado = ""; 
        try{
        this.viaje = viajeBusiness.findPorId(id);
        solicitud.setViaje(viaje);
        resultado = "Vistas/RegistroSolicitud.xhtml";
        }
        catch(Exception ex){
        }
        return resultado;
    }

    public void editSolicitud() {
        try {
            if (this.solicitud.getCodigoSolicitud() != 0) {
                this.solicitud = this.solicitudSeleccionada;
            } else {

            }
        } catch (Exception e) {

        }
    }

    public void deleteSolicitud() {
        try {
            if (this.solicitudSeleccionada != null) {
                solicitudBusiness.delete(solicitudSeleccionada);
                loadSolicitudes();
                cleanForm();
            } else {

            }
        } catch (Exception ex) {

        }
    }

    public void selectSolicitud(SelectEvent e) {
        this.solicitudSeleccionada = (Solicitud) e.getObject();
    }

    public void cleanForm() {
        this.solicitud = new Solicitud();
        this.solicitudSeleccionada = null;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public List<Usuario> getClientes() {
        return clientes;
    }

    public void setClientes(List<Usuario> clientes) {
        this.clientes = clientes;
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

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Solicitud getSolicitudSeleccionada() {
        return solicitudSeleccionada;
    }

    public void setSolicitudSeleccionada(Solicitud solicitudSeleccionada) {
        this.solicitudSeleccionada = solicitudSeleccionada;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

}
