package com.hospital_vm_cl.hospital_vm.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Persona {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id; //Aqui se genera el id, se supone q debe ser numerico, ahora la cosa es como lo conecto a la clase
    
    @Column(unique=true, length = 13, nullable = false)
    @NotBlank(message = "El Run no puede ser invalido")
    @Size(max = 13, message = "El run no puede superar los 13 caracteres") 
    private String run; //AQUI SE IDENTIFICA EL RUT

    @Column(nullable = false, length = 125)
    @NotBlank(message = "el nombre no puede estar en blanco")
    private String nombre;//AQUI EL NOMBRE

    @Column(nullable = false, length = 125)
    @NotBlank(message = "Los apellidos no pueden estar en blanco")
    private String apellidos;//Y AQUI LOS APELLIDOS

    @Column(nullable = false)
    @NotNull(message = "La fecha de nacimiento no puede estar en blanco")
    private LocalDate fecha_nacimiento;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "El correo no puede estar vacio")
    private String correo;

    @Column(nullable = false, length = 15)
    @NotNull(message= "El numero de contacto no puede estar vacio")
    private int telefono;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "La direccion no puede estar vacia")
    private String direccion;
}
