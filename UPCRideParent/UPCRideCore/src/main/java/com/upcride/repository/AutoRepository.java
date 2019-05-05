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

import com.upcride.entity.Auto;

public interface AutoRepository extends JPArepository<Auto>{
    String insertAuto(Auto a) throws Exception;
    String updateAuto(Auto a) throws Exception;
    String deleteAuto(Auto a) throws Exception;
    
}
