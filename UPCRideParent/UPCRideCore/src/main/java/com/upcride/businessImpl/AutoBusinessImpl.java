/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.businessImpl;

import com.upcride.business.AutoBusiness;
import com.upcride.entity.Auto;
import com.upcride.repository.AutoRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

/**
 *
 * @author bryan
 */
@Named
public class AutoBusinessImpl implements AutoBusiness, Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private AutoRepository autoRepository;
    
    @Transactional
    @Override
    public String insertAuto(Auto a) throws Exception{
        return autoRepository.insertAuto(a);
    }

    @Transactional
    @Override
    public String updateAuto(Auto a) throws Exception{
        return autoRepository.updateAuto(a);
    }

    @Transactional
    @Override
    public String deleteAuto(Auto a) throws Exception{
        return autoRepository.deleteAuto(a);
    }
    
    @Override
    public Integer insert(Auto a) throws Exception{
        return 1;
    }
    
      @Override
    public Integer update(Auto a) throws Exception{
        return 1;
    }
    
      @Override
    public Integer delete(Auto a) throws Exception{
        return 1;
    }

    @Override
    public List<Auto> list() throws Exception{
        return autoRepository.list();
    }

    @Override
    public Auto findById(Auto a) throws Exception{
        return autoRepository.findById(a);
    }
}