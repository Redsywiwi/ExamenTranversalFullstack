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
public class Urgencias {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id; 
    
    @Column(unique=true, nullable = false)
    @NotNull(message = "El id del paciente no puede estar vacio") 
    private int id_paciente;

    @Column(nullable = false)
    @NotNull(message = "El campo de fecha y hora de ingreso no puede estar vacio")
    private LocalDateTime fechayhora;

    @Column(nullable = false)
    @NotBlank(message = "el campo de signos vitales no puede estar vacio")
    private String signos_vitales;

    @Column(nullable = false)
    @NotNull(message = "el id del medico asignado no puede estar vacio")
    private int medico_asign;

    @Column(nullable = false)
    @NotBlank(message= "el campo de destino de salida no puede estar vacio")
    private String destino_salida; //si se le dio el alta, quedo hospitalizado o se murio

    
}
