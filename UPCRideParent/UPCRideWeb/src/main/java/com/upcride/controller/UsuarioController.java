/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.controller;

import com.upcride.business.AutoBusiness;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.upcride.business.UsuarioBusiness;
import com.upcride.business.DistritoBusiness;
import com.upcride.entity.Auto;
import com.upcride.entity.Usuario;
import com.upcride.entity.Distrito;
import java.util.List;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author sebas
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioBusiness usuarioBusiness;

    @Inject
    private DistritoBusiness distritoBusiness;

    @Inject
    private AutoBusiness autoBusiness;

    private Usuario usuario;
    private Usuario usuarioSeleccionado;
    private List<Usuario> usuarios;

    private Distrito distrito;
    private List<Distrito> distritos;

    private Auto auto;
    private List<Auto> autos;

  
    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        usuarioSeleccionado = new Usuario();
        auto = new Auto();
        this.loadUsuarios();
        this.loadDistritos();
        this.loadAutos();
    }

    public String iniciarSesion() {
        String resultado = "";
        try {
            usuarioBusiness.iniciarSesion(usuario);
            resultado = "/Vistas/Home.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "El usuario o contraseña es invalido"));
        }
        return resultado;
    }
    

    public void loadUsuarios() {
        try {
            this.usuarios = usuarioBusiness.list();
        } catch (Exception e) {
        }
    }

    public void loadDistritos() {
        try {
            this.distritos = distritoBusiness.list();
        } catch (Exception e) {
        }
    }

    public void loadAutos() {
        try {
            
            this.autos = autoBusiness.list();
        } catch (Exception e) {
        }
    }
    
    

    public void saveUsuario() {
        try {
          
            
            usuario.setDistrito(distrito);
            
            if(usuario.getFacebookID() == null && usuario.getTelefono() == null){
                usuario.setRol(0);
            }
            else {
                saveAuto();
                usuario.setRol(1);
            }
            usuarioBusiness.insertUsuario(usuario);

            loadUsuarios();
            cleanForm();
        } catch (Exception e) {

        }
    }

    public void saveAuto(){
        try{
            autoBusiness.insertAuto(auto);
            usuario.setAuto(auto);
        }catch(Exception ex){
            
        }
    }
    public void editUsuario() {
        try {
            if (this.usuario.getCodigo() != null) {
                this.usuario = this.usuarioSeleccionado;
            } else {

            }
        } catch (Exception e) {

        }
    }

    public void deleteUsuario() {
        try {
            if (this.usuarioSeleccionado != null) {
                usuarioBusiness.delete(usuarioSeleccionado);
                loadUsuarios();
                cleanForm();
            } else {

            }
        } catch (Exception ex) {

        }
    }

    public void selectUsuario(SelectEvent e) {
        this.usuarioSeleccionado = (Usuario) e.getObject();
    }

    public void cleanForm() {
        this.usuario = new Usuario();
        this.usuarioSeleccionado = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public List<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<Distrito> distritos) {
        this.distritos = distritos;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

}
