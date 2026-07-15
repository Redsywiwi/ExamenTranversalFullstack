package com.hospital_vm_cl.hospital_vm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm_cl.hospital_vm.Model.Recetas;
import com.hospital_vm_cl.hospital_vm.Service.RecetasService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/recetas")
@Tag(name = "Recetas", description = "Operaciones relacionadas a las recetas")
public class RecetasControler {
    
    @Autowired
    private RecetasService recetasService;


    @Operation(summary = "Mostrar recetas", description = "Muestra todas las recetas registradas")
    @GetMapping
    public ResponseEntity<List<Recetas>> listar(){
        List<Recetas> recetas = recetasService.findAll();
        if (recetas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recetas);
    }


    //metodo para guardar
    @Operation(summary = "Guardar recetas", description = "Guarda datos de una recetas")
    @PostMapping
    public ResponseEntity<Recetas> guardar(@Valid @RequestBody Recetas recetas){
        Recetas productoNuevo = recetasService.save(recetas);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }


    //metodo para buscar por id
    @Operation(summary = "Buscar recetas", description = "Busca una receta existente por su id")
    @GetMapping("/{id}")
    public ResponseEntity<Recetas> buscar (@PathVariable Integer id){
        try{
            Recetas recetas = recetasService.findById(id);
            return ResponseEntity.ok(recetas);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo para Actualizar por id
    @Operation(summary = "Actualizar recetas", description = "Actualiza los datos de una receta existente")
    @PutMapping ("/{id}")
    public ResponseEntity<Recetas> actualizar(@PathVariable Integer id,@Valid @RequestBody Recetas recetas){
        try {
            Recetas rec = recetasService.findById(id);
            rec.setId(id);
            rec.setId_cita(recetas.getId_cita());
            rec.setDetalle_medicamento(recetas.getDetalle_medicamento());
            rec.setFecha_vencimiento(recetas.getFecha_vencimiento());
            rec.setId_medico(recetas.getId_medico());
            rec.setFirma_digital(recetas.getFirma_digital());


            recetasService.save(rec);
            return ResponseEntity.ok(recetas);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar recetas", description = "Borra una receta ya existente por su id")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            recetasService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
