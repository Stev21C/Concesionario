package com.projectcoches.ProjectConcesionarioCoches.controller;

import com.projectcoches.ProjectConcesionarioCoches.domain.pojo.MarcaCochePojo;
import com.projectcoches.ProjectConcesionarioCoches.domain.service.IMarcaCocheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controlador rest de marca coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas_coches")
public class MarcaCocheController {
    /**
     * Servicio de marca coches
     */
    private final IMarcaCocheService iMarcaCocheService;

    @GetMapping()
    public ResponseEntity<List<MarcaCochePojo>> getAll(){
        return ResponseEntity.ok(iMarcaCocheService.getAll());
        //return ResponseEntity.status(HttpStatus.OK).body(iMarcaCocheService.getAll());
        //return ResponseEntity.status(HttpStatus.OK).body(iMarcaCocheService.getAll());
        //return new ResponseEntity<>(iMarcaCocheService.getAll(), HttpStatus.OK); // Alternativa crear response entity
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MarcaCochePojo> getMarcaCoche(@PathVariable Integer id){
        return ResponseEntity.of(iMarcaCocheService.getMarcaCoche(id));
    }

    @PostMapping
    public ResponseEntity<MarcaCochePojo> save(@RequestBody MarcaCochePojo marcaCochePojoNew){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(iMarcaCocheService.save(marcaCochePojoNew));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

}
