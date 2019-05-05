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

import com.upcride.repository.DistritoRepository;
import com.upcride.entity.Distrito;

@Named
public class DistritoRepositoryImpl implements DistritoRepository, Serializable {
    
       private static final long serialVersionUID = 1L;
    
       @PersistenceContext(unitName = "UPCRidePU")
        private EntityManager em;
       
       @Override
       public Integer insert(Distrito d) throws Exception{
           em.persist(d);
           return d.getCodigoDistrito();
       }
       @Override
       public Integer update(Distrito d) throws Exception{
          em.merge(d);
          return d.getCodigoDistrito();
       }
       @Override
       public Integer delete(Distrito d) throws Exception{
           em.remove(d);
           return d.getCodigoDistrito();
       }
       
       @Override
       public List<Distrito> list() throws Exception{
           List<Distrito> distritos = new ArrayList<Distrito>();
           Query q = em.createQuery("Select d from Distrito d");
           distritos = (List<Distrito>) q.getResultList();
           return distritos;
       }
	
       @SuppressWarnings("unchecked")
       @Override
       public Distrito findById(Distrito d) throws Exception{
           List<Distrito> distritos = new ArrayList<Distrito>();
           Query q = em.createQuery("SELECT FROM Distrito d where d.codigoDistrito = ?1");
           q.setParameter(1, d.getCodigoDistrito());
           
           distritos = (List<Distrito>) q.getResultList();
           
           return distritos != null && !distritos.isEmpty() ? distritos.get(0) : new Distrito();
       } 
        
        
}
