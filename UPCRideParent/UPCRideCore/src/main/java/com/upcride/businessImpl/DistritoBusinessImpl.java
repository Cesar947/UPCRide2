/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.businessImpl;

/**
 *
 * @author César Alejandro
 */

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.inject.Named;

import com.upcride.business.DistritoBusiness;
import com.upcride.repository.DistritoRepository;
import com.upcride.entity.Distrito;


@Named
public class DistritoBusinessImpl implements DistritoBusiness, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private DistritoRepository distritoRepository;
    
    @Transactional
    @Override
    public Integer insert(Distrito d) throws Exception{
        return distritoRepository.insert(d);
    }
    
    @Transactional
    @Override     
    public Integer update(Distrito d) throws Exception{
        return distritoRepository.update(d);
    }
    @Transactional
    @Override
    public Integer delete(Distrito d) throws Exception{
      return distritoRepository.delete(d);
    }
    
    @Override
    public List<Distrito> list() throws Exception{
        return distritoRepository.list();
    }
    @Override
    public Distrito findById(Distrito d) throws Exception{
        return distritoRepository.findById(d);
    } 
}
