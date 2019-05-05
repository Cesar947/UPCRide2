/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.repositoryImpl;

/**
 *
 * @author Bryan
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.upcride.repository.AutoRepository;
import com.upcride.entity.Auto;

@Named
public class AutoRepositoryImpl implements AutoRepository, Serializable {
   
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(unitName = "UPCRidePU")
     private EntityManager em;
    
    
    @Override
    public Integer insert(Auto u) throws Exception{
       return 1;
    }
    
       
    @Override
    public Integer update(Auto u) throws Exception{
       return 1;
    }
    
       
    @Override
    public Integer delete(Auto u) throws Exception{
       return 1;
    }
    
    @Override
    public String insertAuto(Auto u) throws Exception{
        em.persist(u);
        return u.getPlaca();
    }
    
    @Override 
    public String updateAuto(Auto u) throws Exception{
        em.merge(u);
        return u.getPlaca();
    }
    
    @Override          
    public String deleteAuto(Auto u) throws Exception{
        em.remove(u);
        return u.getPlaca();
    }
    @Override
    public List<Auto> list() throws Exception{
        List<Auto> autos = new ArrayList<Auto>();
        Query q = em.createQuery("Select u from Auto u ");
        autos = (List<Auto>) q.getResultList();
        return autos;
    }
    
    
    public Auto findById(Auto u) throws Exception{
        List<Auto> autos = new ArrayList<Auto>();
        Query q = em.createQuery("Select from Auto u where u.placa = ?1");
        q.setParameter(1, u.getPlaca());
        autos = (List<Auto>) q.getResultList();
        return autos != null && !autos.isEmpty() ? autos.get(0) : new Auto();
    } 
}
