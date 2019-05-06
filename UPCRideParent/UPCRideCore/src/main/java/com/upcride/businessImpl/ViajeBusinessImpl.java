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

import com.upcride.business.ViajeBusiness;
import com.upcride.repository.ViajeRepository;
import com.upcride.entity.Viaje;


@Named
public class ViajeBusinessImpl implements ViajeBusiness, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ViajeRepository viajeRepository;
    
    @Transactional
    @Override
    public Integer insert(Viaje v) throws Exception{
        return viajeRepository.insert(v);
    }
    
    @Transactional
    @Override     
    public Integer update(Viaje v) throws Exception{
        return viajeRepository.update(v);
    }
    @Transactional
    @Override
    public Integer delete(Viaje v) throws Exception{
      return viajeRepository.delete(v);
    }
    
    @Override
    public List<Viaje> list() throws Exception{
        return viajeRepository.list();
    }
    @Override
    public Viaje findById(Viaje v) throws Exception{
        return viajeRepository.findById(v);
    } 
    
    @Override
    public List<Viaje>buscarViajes(Viaje viajeFiltro) throws Exception{
        return viajeRepository.buscarViajes(viajeFiltro);
    }
    
    @Override
    public Viaje findPorId(int id) throws Exception{
        return viajeRepository.findPorId(id);
    }
}
