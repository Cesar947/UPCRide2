/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.repositoryImpl;

import com.upcride.entity.Viaje;
import com.upcride.repository.ViajeRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author César Alejandro
 */
@Named
public class ViajeRepositoryImpl implements ViajeRepository, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "UPCRidePU")
    private EntityManager em;

    @Override
    public Integer insert(Viaje v) throws Exception {
        em.persist(v);
        return v.getCodigo();
    }

    @Override
    public Integer update(Viaje v) throws Exception {
        em.merge(v);
        return v.getCodigo();
    }

    @Override
    public Integer delete(Viaje v) throws Exception {
        em.remove(v);
        return v.getCodigo();
    }
    /*
     @Override
     public List<Viaje> list() throws Exception{
     List<Viaje> distritos = new ArrayList<Viaje>();
     Query q = em.createQuery("Select d from Viaje v");
     distritos = (List<Viaje>) q.getResultList();
     return distritos;
     }*/

    @Override
    public List<Viaje> list() throws Exception {
        List<Viaje> viajes = new ArrayList<>();
        Query q = em.createQuery("Select v from Viaje v");
        viajes = (List<Viaje>) q.getResultList();
        return viajes;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Viaje findById(Viaje v) throws Exception {
        List<Viaje> viajes = new ArrayList<>();
        Query q = em.createQuery("SELECT FROM Viaje v where v.codigoViaje = ?1");
        q.setParameter(1, v.getCodigo());

        viajes = (List<Viaje>) q.getResultList();

        return viajes != null && !viajes.isEmpty() ? viajes.get(0) : new Viaje();
    }

    @Override
    public List<Viaje> buscarViajes(Viaje viajeFiltro) throws Exception {

        /*
         select*
         from viaje v
         where v.puntoPartida = ?pntPartida and v.puntoDestino= ?pntDestino and v.fechaviaje = ?fecha and v.horaLlegada between ?hora - 1 and ?hora + 1 and v.entrada_salida = ?ida_regreso
         select*
         from viaje v
         where v.puntoPartida = ?pntPartida and v.puntoDestino= ?pntDestino and v.fechaviaje = ?fecha and v.horaPartida between ?hora - 1 and ?hora + 1 and v.entrada_salida = ?ida_regreso
         */
        List<Viaje> resultadoBusqueda = new ArrayList<>();
     
        Query q = em.createQuery("select v from viaje v where v.puntoPartida = ?1 "
                + "and v.puntoDestino= ?2 and v.fechaviaje = ?3 and v.horaLlegada between ?4 - 1 "
                + "and ?4 + 1 and v.entrada_salida = ?6");
        q.setParameter(1, viajeFiltro.getPuntoPartida());
        q.setParameter(2, viajeFiltro.getPuntoDestino());
        q.setParameter(3, viajeFiltro.getFechaViaje());
        q.setParameter(4, viajeFiltro.getHoraLlegada());
        q.setParameter(5, viajeFiltro.getHoraPartida());
        q.setParameter(6, viajeFiltro.getEntrada_salida());

        resultadoBusqueda = (List<Viaje>) q.getResultList();

        return resultadoBusqueda;
    }

}
