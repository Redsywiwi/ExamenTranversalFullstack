package com.hospital_vm_cl.hospital_vm.Controller;
import com.hospital_vm_cl.hospital_vm.Model.Paciente;
import com.hospital_vm_cl.hospital_vm.Service.PacienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
@Tag(name = "Paciente", description = "Operaciones relacionadas a los pacientes")
public class PacienteControler {
    
    @Autowired
    private PacienteService pacienteService;


    @Operation(summary = "Mostrar pacientes", description = "Muestra todos los pacientes registrados")
    @GetMapping
    public ResponseEntity<List<Paciente>> listar(){
        List<Paciente> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);
    }


    //metodo para guardar
    @Operation(summary = "Guardar Pacientes", description = "Guarda datos de un paciente")
    @PostMapping
    public ResponseEntity<Paciente> guardar(@Valid @RequestBody Paciente paciente){
        Paciente productoNuevo = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }


    //metodo para buscar por id
    @Operation(summary = "Buscar Paciente", description = "Busca un paciente existente por su id")
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar (@PathVariable Integer id){
        try{
            Paciente paciente = pacienteService.findById(id);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo para Actualizar por id
    @Operation(summary = "Actualizar paciente", description = "Actualiza los datos de un paciente existente")
    @PutMapping ("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Integer id,@Valid @RequestBody Paciente paciente){
        try {
            Paciente pac = pacienteService.findById(id);
            pac.setId(id);
            pac.setRun(paciente.getRun());
            pac.setNombre(paciente.getNombre());
            pac.setApellidos(paciente.getApellidos());
            pac.setFecha_nacimiento(paciente.getFecha_nacimiento());
            pac.setDireccion(paciente.getDireccion());
            pac.setCorreo(paciente.getCorreo());
            pac.setTelefono(paciente.getTelefono());
            pac.setFecha_registro(paciente.getFecha_registro());

            pacienteService.save(pac);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar Paciente", description = "Borra un paciente ya existente por su id")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            pacienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}