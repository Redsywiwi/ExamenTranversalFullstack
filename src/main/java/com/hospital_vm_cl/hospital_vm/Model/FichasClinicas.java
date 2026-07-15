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
public class FichasClinicas {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id; //Aqui se genera el id, se supone q debe ser numerico, ahora la cosa es como lo conecto a la clase
    
    @Column(nullable = false)
    @NotNull(message = "El campo Id Paciente no puede estar vacio")
    private int id_paciente;

    @Column(nullable = false)
    @NotNull(message = "El campo fecha de apertura no puede estar vacio")
    private LocalDate fecha_apertura; //este a diferencia del otro localdate solo muestra el año, mes y dia, el otro muestra eso junto con la hora

    @Column(nullable = false, length = 5)
    @NotNull(message = "El campo grupo sanguineo no puede estar vacio")
    private String grupo_sanguineo;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "El campo alergias no puede estar vacio")
    private String Alergias;

    @Column(nullable = false, length = 555)
    @NotBlank(message = "el campo antecedentes medicos no puede estar vacio")
    private String antecedentes_medicos;

}
