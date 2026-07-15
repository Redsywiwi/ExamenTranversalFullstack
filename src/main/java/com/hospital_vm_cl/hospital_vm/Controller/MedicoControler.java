package com.hospital_vm_cl.hospital_vm.Controller;

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
import java.util.List;
import com.hospital_vm_cl.hospital_vm.Model.Medico;
import com.hospital_vm_cl.hospital_vm.Service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/medico")
@Tag(name = "Medico", description = "Operaciones relacionadas a los Medicos")
public class MedicoControler {
    
    @Autowired
    private MedicoService medicoService;


    @Operation(summary = "Mostrar medicos", description = "Muestra todos los medicos registrados")
    @GetMapping
    public ResponseEntity<List<Medico>> listar(){
        List<Medico> medicos = medicoService.findAll();
        if (medicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(medicos);
    }


    //metodo para guardar
    @Operation(summary = "Guardar Medicos", description = "Guarda datos de un medico")
    @PostMapping
    public ResponseEntity<Medico> guardar(@Valid @RequestBody Medico medico){
        Medico productoNuevo = medicoService.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }


    //metodo para buscar por id
    @Operation(summary = "Buscar Medico", description = "Busca un medico existente por su id")
    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscar (@PathVariable Integer id){
        try{
            Medico medico = medicoService.findById(id);
            return ResponseEntity.ok(medico);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo para Actualizar por id
    @Operation(summary = "Actualizar medico", description = "Actualiza los datos de un medico existente")
    @PutMapping ("/{id}")
    public ResponseEntity<Medico> actualizar(@PathVariable Integer id,@Valid @RequestBody Medico medico){
        try {
            Medico med = medicoService.findById(id);
            med.setId(id);
            med.setRun(medico.getRun());
            med.setNombre(medico.getNombre());
            med.setApellidos(medico.getApellidos());
            med.setFecha_nacimiento(medico.getFecha_nacimiento());
            med.setDireccion(medico.getDireccion());
            med.setCorreo(medico.getCorreo());
            med.setTelefono(medico.getTelefono());
            med.setFecha_contratacion(medico.getFecha_contratacion());
            med.setTurno(medico.getTurno());
            med.setSalario(medico.getSalario());

            medicoService.save(med);
            return ResponseEntity.ok(medico);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar Medico", description = "Borra un medico ya existente por su id")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            medicoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
