/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upcride.business;

/**
 *
 * @author César Alejandro
 */
import com.upcride.entity.Auto;


public interface AutoBusiness extends CRUDbusiness<Auto> {
        String insertAuto(Auto u) throws Exception;
	String updateAuto(Auto u) throws Exception;
	String deleteAuto(Auto u) throws Exception;
}
