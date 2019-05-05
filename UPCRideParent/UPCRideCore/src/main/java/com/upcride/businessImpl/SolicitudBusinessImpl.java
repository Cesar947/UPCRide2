/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.businessImpl;

import com.upcride.business.SolicitudBusiness;
import com.upcride.entity.Solicitud;
import com.upcride.repository.SolicitudRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author sebas
 */
public class SolicitudBusinessImpl implements SolicitudBusiness, Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SolicitudRepository solicitudRepository;

    @Transactional
    @Override
    public Integer insert(Solicitud s) throws Exception {
        return solicitudRepository.insert(s);
    }

    @Transactional
    @Override
    public Integer update(Solicitud s) throws Exception {
        return solicitudRepository.update(s);
    }

    @Transactional
    @Override
    public Integer delete(Solicitud s) throws Exception {
        return solicitudRepository.delete(s);
    }

    @Override
    public List<Solicitud> list() throws Exception {
        return solicitudRepository.list();
    }

    @Override
    public Solicitud findById(Solicitud s) throws Exception {
        return solicitudRepository.findById(s);
    }

}
