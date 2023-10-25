/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica01.practica01.service;
import com.practica01.practica01.domain.Arbol;
import java.util.List;
/**
 *
 * @author arjoz
 */
public interface ArbolService {
    
    public List<Arbol> getArboles(boolean Activo);
    // Se obtiene un Arbol, a partir del id de un arbol
     public Arbol getArbol(Arbol arbol);
     
      // Se inserta un nuevo arbol si el id del arbol esta vacío
    // Se actualiza un arbol si el id del arbol NO esta vacío
    public void save(Arbol arbol);
    
    // Se elimina el arbol que tiene el id pasado por parámetro
    public void delete(Arbol arbol);
    
    
}
