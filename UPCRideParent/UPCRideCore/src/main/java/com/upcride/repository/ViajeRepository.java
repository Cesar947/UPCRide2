/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.repository;

/**
 *
 * @author César Alejandro
 */

import com.upcride.entity.Viaje;
import java.util.List;

public interface ViajeRepository extends JPArepository<Viaje>{
    
    List<Viaje> buscarViajes(Viaje viajeFiltro) throws Exception;
    
    Viaje findPorId(int id) throws Exception;
}
