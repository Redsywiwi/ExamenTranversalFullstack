package com.hospital_vm_cl.hospital_vm.Model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Medico extends Persona {

    @Column(nullable = false)
    @NotNull(message = "El campo salario no puede estar vacio")
    private int salario;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "el campo de turno no puede estar vacio")
    private String turno;
    
    @Column(nullable = false)
    @NotNull(message = "El campo fecha de contratacion no puede estar vacio")
    private LocalDate fecha_contratacion;



    public Medico(Integer id, String run, String nombre, String apellidos, LocalDate fecha_nacimiento, String correo, Integer telefono, String direccion, int salario, String turno, LocalDate fecha_contratacion) 
    {
        super(id, run, nombre, apellidos, fecha_nacimiento, correo, telefono, direccion);
        this.salario = salario;
        this.turno = turno;
        this.fecha_contratacion = fecha_contratacion;
    }
}
