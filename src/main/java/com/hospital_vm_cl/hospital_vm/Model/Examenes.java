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
public class Examenes {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id; //Aqui se genera el id, se supone q debe ser numerico, ahora la cosa es como lo conecto a la clase
    
    @Column(nullable = false)
    @NotNull(message = "El campo id paciente no puede estar vacio")
    private int id_paciente;

    @Column(nullable = false)
    @NotNull(message = "El campo Id medico no puede estar vacio")
    private int id_medico;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "El campo tipo de examen no puede estar vacio")
    private String tipo_examen;

    @Column(nullable = false)
    @NotNull(message = "El campo de fecha de solicitud no puede estar vacio")
    private LocalDate fecha_solicitud;

    @Column(nullable = false)
    @NotBlank(message = "El campo fecha de realizacion no puede estar vacio")
    private String fecha_realizacion;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "El campo de estado no puede estar vacio")
    private String estado;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "El campo de resultado no puede estar vacio")
    private String resultado;
}
