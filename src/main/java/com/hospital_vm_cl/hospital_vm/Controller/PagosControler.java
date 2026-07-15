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
import com.hospital_vm_cl.hospital_vm.Model.Pagos;
import com.hospital_vm_cl.hospital_vm.Service.PagosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/pagos")
@Tag(name = "pagos", description = "Operaciones relacionadas a los pagos")
public class PagosControler {
    
    @Autowired
    private PagosService pagosService;


    @Operation(summary = "Mostrar pagos", description = "Muestra todos los pagos registrados")
    @GetMapping
    public ResponseEntity<List<Pagos>> listar(){
        List<Pagos> pagos = pagosService.findAll();
        if (pagos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pagos);
    }


    //metodo para guardar
    @Operation(summary = "Guardar Pagos", description = "Guarda datos de un pago")
    @PostMapping
    public ResponseEntity<Pagos> guardar(@Valid @RequestBody Pagos pagos){
        Pagos productoNuevo = pagosService.save(pagos);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }


    //metodo para buscar por id
    @Operation(summary = "Buscar pagos", description = "Busca un pago existente por su id")
    @GetMapping("/{id}")
    public ResponseEntity<Pagos> buscar (@PathVariable Integer id){
        try{
            Pagos pagos = pagosService.findById(id);
            return ResponseEntity.ok(pagos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo para Actualizar por id
    @Operation(summary = "Actualizar pagos", description = "Actualiza los datos de un pago existente")
    @PutMapping ("/{id}")
    public ResponseEntity<Pagos> actualizar(@PathVariable Integer id,@Valid @RequestBody Pagos pagos){
        try {
            Pagos pag = pagosService.findById(id);
            pag.setId(id);
            pag.setId_cita(pagos.getId_cita());
            pag.setId_hospitalizacion(pagos.getId_hospitalizacion());
            pag.setId_paciente(pagos.getId_paciente());
            pag.setMonto(pagos.getMonto());
            pag.setConvenio(pagos.getConvenio());

            pagosService.save(pag);
            return ResponseEntity.ok(pagos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar pagos", description = "Borra un pago ya existente por su id")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            pagosService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
