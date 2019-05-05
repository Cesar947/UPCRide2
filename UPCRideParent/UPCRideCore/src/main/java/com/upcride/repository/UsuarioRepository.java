/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.repository;

import com.upcride.entity.Usuario;

/**
 *
 * @author César Alejandro
 */
public interface UsuarioRepository extends JPArepository<Usuario>{
    String insertUsuario(Usuario u) throws Exception;
    String updateUsuario(Usuario u) throws Exception;
    String deleteUsuario(Usuario u) throws Exception;
    String iniciarSesion(Usuario u) throws Exception;
}
