/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.controller;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.upcride.business.UsuarioBusiness;
import com.upcride.business.ResenaBusiness;
import com.upcride.entity.Resena;
import com.upcride.entity.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 *
 * @author sebas
 */
@Named
@ViewScoped
public class ResenaController implements Serializable {

    private static final long serialVersionUID = 1L;

  
    @Inject
    private ResenaBusiness resenaBusiness;
    @Inject
    private UsuarioBusiness conductorBusiness;
    @Inject
    private UsuarioBusiness clienteBusiness;
  

    private Usuario conductor;
    private List<Usuario> conductores;

    private Usuario cliente;
    private List<Usuario> clientes;
    
    private Resena resena;
    private Resena resenaSeleccionada;
    private List<Resena> resenas;


    @PostConstruct
    public void init() {
        resena = new Resena();
        resenaSeleccionada = new Resena();
        conductor = new Usuario();
        cliente = new Usuario();
        
 
        this.loadResenas();
        this.loadClientes();
        this.loadConductores();
    
    }

    public void loadResenas() {
        try {
            this.resenas = resenaBusiness.list();
        } catch (Exception e) {
        }
    }

    public void loadClientes() {
        try {
            this.clientes = clienteBusiness.list();
        } catch (Exception e) {
        }
    }

    public void loadConductores() {
        try {
            this.conductores = conductorBusiness.list();
        } catch (Exception e) {
        }
    }

    public void saveResena() {
        try {
            
            
            resena.setConductor(conductor);
            resena.setCliente(cliente);
            resenaBusiness.insert(resena);

            loadResenas();
            cleanForm();
        } catch (Exception e) {

        }
    }

    public void editResena() {
        try {
            if (this.resena.getCodigo() != 0) {
                this.resena = this.resenaSeleccionada;
            } else {

            }
        } catch (Exception e) {

        }
    }

    public void deleteResena() {
        try {
            if (this.resenaSeleccionada != null) {
                resenaBusiness.delete(resenaSeleccionada);
                loadResenas();
                cleanForm();
            } else {

            }
        } catch (Exception ex) {

        }
    }

    public void selectResena(SelectEvent e) {
        this.resenaSeleccionada = (Resena) e.getObject();
    }

    public void cleanForm() {
        this.resena = new Resena();
        this.resenaSeleccionada = null;
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

    public Resena getResena() {
        return resena;
    }

    public void setResena(Resena resena) {
        this.resena = resena;
    }

    public Resena getResenaSeleccionada() {
        return resenaSeleccionada;
    }

    public void setResenaSeleccionada(Resena resenaSeleccionada) {
        this.resenaSeleccionada = resenaSeleccionada;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }

   
}
