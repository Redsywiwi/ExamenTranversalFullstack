package com.hospital_vm_cl.hospital_vm.Model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Recetas {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id; //Aqui se genera el id, se supone q debe ser numerico, ahora la cosa es como lo conecto a la clase
    
    @Column(nullable = false)
    @NotNull(message = "El campo id cita no puede estar vacio")
    private int id_cita;

    @Column(nullable = false)
    @NotNull(message = "El campo Id medico no puede estar vacio")
    private int id_medico;

    @Column(nullable = false)
    @NotNull(message = "El campo fecha de emision no puede estar vacio")
    private LocalDate fecha_emision; //Fecha

    @Column(nullable = false)
    @NotNull(message = "El campo de Fecha Vencimiento no puede estar vacio")
    private LocalDate fecha_vencimiento;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "el campo detalle medicamentos no puede estar vacio")
    private String detalle_medicamento;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "el campo firma digital no puede estar vacio")
    private String firma_digital;
}
