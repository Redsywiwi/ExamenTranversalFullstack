package com.hospital_vm_cl.hospital_vm.Model;

import java.time.LocalDateTime;

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
public class Hospitalizacion {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id; //Aqui se genera el id, se supone q debe ser numerico, ahora la cosa es como lo conecto a la clase
    
    @Column(nullable = false)
    @NotNull(message = "El campo Id Paciente no puede estar vacio")
    private int id_paciente;

    @Column(nullable = false)
    @NotNull(message = "El campo Id medico no puede estar vacio")
    private int id_medico;

    @Column(nullable = false)
    @NotNull(message = "El campo fecha y hora de entrada no puede estar vacio")
    private LocalDateTime fecha_hora_in; //Fecha y hora, no mucho mas loco

    @Column(nullable = false)
    @NotNull(message = "El campo fecha y hora de alta no puede estar vacio")
    private LocalDateTime fecha_hora_out; //Fecha y hora, no mucho mas loco

    @Column(nullable = false, length = 25)
    @NotBlank(message = "El campo de habitacion no puede estar vacio")
    private String habitacion; //string en caso de que alguna habitacion tenga una letra

    @Column(nullable = false, length = 10)
    @NotBlank(message = "El campo de cama no puede estar vacio")
    private String cama; //lo mismo que la anterior solo que en lugar de identificar las camas por numero sea por letras

    @Column(nullable = false)
    @NotNull(message = "El campo de piso no puede estar vacio")
    private int piso;

    @Column(nullable = false, length = 550)
    @NotBlank(message = "el campo de diagnostico no puede estar vacio")
    private String diagnostico;

    @Column(nullable = true, length = 550)
    private String resumen_alta;
}
