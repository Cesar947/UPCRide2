/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.repositoryImpl;

import com.upcride.entity.Usuario;
import com.upcride.repository.UsuarioRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author sebas
 */
@Named
public class UsuarioRepositoryImpl implements UsuarioRepository, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "UPCRidePU")
    private EntityManager em;

     @Override
     public String insertUsuario(Usuario u) throws Exception{
         em.persist(u);
         return u.getCodigo();
     }
     
      @Override
     public String updateUsuario(Usuario u) throws Exception{
         em.merge(u);
         return u.getCodigo();
     }
     
      @Override
    public String deleteUsuario(Usuario u) throws Exception{
         em.remove(u);
         return u.getCodigo();
     }
    
    @Override
    public String iniciarSesion(Usuario u) throws Exception{
        
        
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.codigo = ?1 and u.contrasena = ?2");
        q.setParameter(1, u.getCodigo());
        q.setParameter(2, u.getContrasena());
        
        Usuario resultado = (Usuario) q.getSingleResult();
        return resultado.getCodigo();
    }
     
    
    @Override
    public Integer insert(Usuario u) throws Exception {
        return 1;
    }

    @Override
    public Integer update(Usuario u) throws Exception {
        return 1;
    }

    @Override
    public Integer delete(Usuario u) throws Exception {
        return 1;
    }

    @Override
    public List<Usuario> list() throws Exception {
        List<Usuario> usuarios = new ArrayList<Usuario>();

        Query q = em.createQuery("SELECT u FROM Usuario u");
        
        usuarios = (List<Usuario>) q.getResultList();
        return usuarios;
    }
    @SuppressWarnings("unchecked")
    @Override
    public Usuario findById(Usuario u) throws Exception {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.codigo = ?1");
        q.setParameter(1, u.getCodigo());//REVISAR
        
        return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new Usuario();
    }
        
      
}