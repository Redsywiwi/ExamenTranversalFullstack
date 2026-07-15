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

import com.hospital_vm_cl.hospital_vm.Model.Urgencias;
import com.hospital_vm_cl.hospital_vm.Service.UrgenciasService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/urgencias")
@Tag(name = "Urgencias", description = "Operaciones relacionadas a las Urgencias")
public class UrgenciasControler {
    
    @Autowired
    private UrgenciasService urgenciasService;


    @Operation(summary = "Mostrar Urgencias", description = "Muestra todas las urgencias registradas")
    @GetMapping
    public ResponseEntity<List<Urgencias>> listar(){
        List<Urgencias> urgencias = urgenciasService.findAll();
        if (urgencias.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(urgencias);
    }


    //metodo para guardar
    @Operation(summary = "Guardar Urgencias", description = "Guarda datos de una Urgencia")
    @PostMapping
    public ResponseEntity<Urgencias> guardar(@Valid @RequestBody Urgencias urgencias){
        Urgencias productoNuevo = urgenciasService.save(urgencias);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }


    //metodo para buscar por id
    @Operation(summary = "Buscar Urgencias", description = "Busca una urgencia existente por su id")
    @GetMapping("/{id}")
    public ResponseEntity<Urgencias> buscar (@PathVariable Integer id){
        try{
            Urgencias urgencias = urgenciasService.findById(id);
            return ResponseEntity.ok(urgencias);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo para Actualizar por id
    @Operation(summary = "Actualizar urgencias", description = "Actualiza los datos de una urgencia existente")
    @PutMapping ("/{id}")
    public ResponseEntity<Urgencias> actualizar(@PathVariable Integer id,@Valid @RequestBody Urgencias urgencias){
        try {
            Urgencias urg = urgenciasService.findById(id);
            urg.setId(id);
            urg.setId_paciente(urgencias.getId_paciente());
            urg.setMedico_asign(urgencias.getMedico_asign());
            urg.setFechayhora(urgencias.getFechayhora());
            urg.setDestino_salida(urgencias.getDestino_salida());
            urg.setSignos_vitales(urgencias.getSignos_vitales());

            urgenciasService.save(urg);
            return ResponseEntity.ok(urgencias);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar urgencias", description = "Borra una urgencia ya existente por su id")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            urgenciasService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
