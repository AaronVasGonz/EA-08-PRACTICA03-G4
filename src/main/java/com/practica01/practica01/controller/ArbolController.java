
package com.practica01.practica01.controller;

import com.practica01.practica01.domain.Arbol;
import com.practica01.practica01.service.ArbolService;
import com.practica01.practica01.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @Diego Caceres Alvarado
 */
@Controller
@RequestMapping("/arbol")
public class ArbolController {
    @Autowired
    private ArbolService arbolService;
    
     @GetMapping("/listado")
    public String listado(Model model){
        var arboles = arbolService.getArboles(false);
        model.addAttribute("arboles",
                arboles);
        model.addAttribute("totalArboles", arboles.size());
        return "/arbol/listado";
    }
    //comando de nuevo elemento
    @GetMapping("/nuevo")
    public String arbolNuevo(Arbol arbol) {
        return "/arbol/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    //tabla de elementos de agregar
    
    @PostMapping("/guardar")
    public String arbolGuardar(Arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            arbol.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "arbol", 
                            arbol.getId()));
        }
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }
// comando de eliminacion
    @GetMapping("/eliminar/{id}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }
// modicacion de lista
    @GetMapping("/modificar/{id}")
    public String arbolModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }
    
}
