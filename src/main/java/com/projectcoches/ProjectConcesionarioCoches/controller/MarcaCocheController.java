package com.projectcoches.ProjectConcesionarioCoches.controller;

import com.projectcoches.ProjectConcesionarioCoches.domain.pojo.MarcaCochePojo;
import com.projectcoches.ProjectConcesionarioCoches.domain.service.IMarcaCocheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controlador rest de marca coche, seria la API
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas_coches")
public class MarcaCocheController {

    /**
     * Servicio de marca coches
     */
    private final IMarcaCocheService iMarcaCocheService;


    /**
     * Devuelve lista de marcas coche
     * @return lista de pojos de marcas coches, HttpCode Ok
     */
    @GetMapping()      // El metodo va a estar manupulado por metodo GET http, para consultas
    public ResponseEntity<List<MarcaCochePojo>> getAll(){   // Retorna lista de Pojos
        return ResponseEntity.ok(iMarcaCocheService.getAll());
        //return ResponseEntity.status(HttpStatus.OK).body(iMarcaCocheService.getAll());
        //return ResponseEntity.status(HttpStatus.OK).body(iMarcaCocheService.getAll());
        //return new ResponseEntity<>(iMarcaCocheService.getAll(), HttpStatus.OK); // Alternativa crear response entity
    }

    /**
     * Devuelve marca coche dado su ID
     * @param id de la marca coche a buscar
     * @return httCode ok si encuentra, o not found si no
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<MarcaCochePojo>getMarcaCoche(@PathVariable Integer id){
        return ResponseEntity.of(iMarcaCocheService.getMarcaCoche(id));
    }

    /**
     * Crea una nueva marca coche
     * @param marcaCochePojoNew Marca coche a crear
     * @return HttpCode create si la guarda, si no bad request
     */
    @PostMapping
    public ResponseEntity<MarcaCochePojo>save(@RequestBody MarcaCochePojo marcaCochePojoNew){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(iMarcaCocheService.save(marcaCochePojoNew));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    /**
     * Actualiza marca coche
     * @param marcaCochePojoUpdate Marca coche actualizada
     * @return HttpCode OK, si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<MarcaCochePojo>update(@RequestBody MarcaCochePojo marcaCochePojoUpdate){

        /*
        MarcaCochePojo marcaCochePojo = iMarcaCocheService.update(marcaCochePojoUpdate);

        if(marcaCochePojo == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(marcaCochePojo);
        }
        */

        return ResponseEntity.of(iMarcaCocheService.update(marcaCochePojoUpdate));
        //return ResponseEntity.status(HttpStatus.OK).body(iMarcaCocheService.save(marcaCochePojoUpdate));
    }

    /**
     * Elimina marca coche dada su id
     * @param id marca coche a eliminat
     * @return HttpCode OK si la elimina y Not Found si no existe
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean>delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iMarcaCocheService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
