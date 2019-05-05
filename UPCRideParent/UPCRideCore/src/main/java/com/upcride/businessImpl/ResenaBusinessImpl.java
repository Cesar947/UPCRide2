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

import com.upcride.business.ResenaBusiness;
import com.upcride.repository.ResenaRepository;
import com.upcride.entity.Resena;


@Named
public class ResenaBusinessImpl implements ResenaBusiness, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ResenaRepository resenaRepository;
    
    @Transactional
    @Override
    public Integer insert(Resena r) throws Exception{
        return resenaRepository.insert(r);
    }
    
    @Transactional
    @Override     
    public Integer update(Resena r) throws Exception{
        return resenaRepository.update(r);
    }
    @Transactional
    @Override
    public Integer delete(Resena r) throws Exception{
      return resenaRepository.delete(r);
    }
    
    @Override
    public List<Resena> list() throws Exception{
        return resenaRepository.list();
    }
    @Override
    public Resena findById(Resena r) throws Exception{
        return resenaRepository.findById(r);
    } 
}
