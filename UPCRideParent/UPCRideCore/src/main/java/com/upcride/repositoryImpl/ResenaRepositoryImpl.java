/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.repositoryImpl;

/**
 *
 * @author César Alejandro
 */

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.PersistenceContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.upcride.repository.ResenaRepository;
import com.upcride.entity.Resena;

@Named
public class ResenaRepositoryImpl implements ResenaRepository, Serializable {
    
       private static final long serialVersionUID = 1L;
    
       @PersistenceContext(unitName = "UPCRidePU")
        private EntityManager em;
       
       @Override
       public Integer insert(Resena r) throws Exception{
           em.persist(r);
           return r.getCodigo();
       }
       @Override
       public Integer update(Resena r) throws Exception{
          em.merge(r);
          return r.getCodigo();
       }
       @Override
       public Integer delete(Resena r) throws Exception{
           em.remove(r);
           return r.getCodigo();
       }
       
       @Override
       public List<Resena> list() throws Exception{
           List<Resena> resenas = new ArrayList<Resena>();
           Query q = em.createQuery("Select r from Resena r");
           resenas = (List<Resena>) q.getResultList();
           return resenas;
       }
	
       @SuppressWarnings("unchecked")
       @Override
       public Resena findById(Resena r) throws Exception{
           List<Resena> resenas = new ArrayList<Resena>();
           Query q = em.createQuery("SELECT FROM Resena r where r.codigoResena = ?1");
           q.setParameter(1, r.getCodigo());
           
           resenas = (List<Resena>) q.getResultList();
           
           return resenas != null && !resenas.isEmpty() ? resenas.get(0) : new Resena();
       } 
        
        
}
