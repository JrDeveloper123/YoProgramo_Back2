/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backEnd.portfolio_3.security.repository;

import com.backEnd.portfolio_3.security.enums.RolNombre;
import com.backEnd.portfolio_3.security.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface iRolRepository extends JpaRepository<Rol, Integer>{
        Optional<Rol> findByRolNombre(RolNombre rolNombre);
      
}
