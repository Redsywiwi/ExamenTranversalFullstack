package com.hospital_vm_cl.hospital_vm.Model;

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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Aqui se genera el id, se supone q debe ser numerico, ahora la cosa es como lo conecto a la clase
    
    @Column(nullable = false)
    @NotNull(message = "El id del paciente no puede estar vacio") 
    private int id_paciente;//no se como se usan las foreign keys aqui, se que generationtype.idenity es la primary key noma 

    @Column(nullable = true)
    private int id_cita;
    
    @Column(nullable = true)
    private int id_hospitalizacion;

    @Column(nullable = false)
    @NotBlank(message = "el campo convenio no puede estar vacio")
    private String convenio;

    @Column(nullable = false)
    @NotNull(message = "el monto a pagar no puede estar vacio")
    private int monto;
}
