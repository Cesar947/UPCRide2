/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.businessImpl;

import com.upcride.business.UsuarioBusiness;
import com.upcride.entity.Usuario;
import com.upcride.repository.UsuarioRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

/**
 *
 * @author sebas
 */
@Named
public class UsuarioBusinessImpl implements UsuarioBusiness, Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private UsuarioRepository usuarioRepository;
    
    @Override
    public Integer insert(Usuario u) throws Exception{
        return 1;
    }
    @Override
    public Integer update(Usuario u) throws Exception{
        return 1;
    }
    @Override
    public Integer delete(Usuario u) throws Exception{
        return 1;
    }
    
    @Transactional
    @Override
    public String iniciarSesion(Usuario u) throws Exception{
        return usuarioRepository.iniciarSesion(u);
    }
    
    @Transactional
    @Override
    public String insertUsuario(Usuario u) throws Exception{
        return usuarioRepository.insertUsuario(u);
    }

    @Transactional
    @Override
    public String updateUsuario(Usuario u) throws Exception{
        return usuarioRepository.updateUsuario(u);
    }

    @Transactional
    @Override
    public String deleteUsuario(Usuario u) throws Exception{
        return usuarioRepository.deleteUsuario(u);
    }

    @Override
    public List<Usuario> list() throws Exception{
        return usuarioRepository.list();
    }

    @Override
    public Usuario findById(Usuario u) throws Exception{
        return usuarioRepository.findById(u);
    }
}