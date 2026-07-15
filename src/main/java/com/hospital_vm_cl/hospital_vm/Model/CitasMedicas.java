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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CitasMedicas {
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
    @NotNull(message = "El campo fecha y hora no puede estar vacio")
    private LocalDateTime fechayhora; //Fecha y hora, no mucho mas loco

    @Column(nullable = false, length = 100)
    @NotBlank(message = "El campo de estado de cita no puede estar vacio")
    private String estado_cita;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "el campo de motivo de la consulta no puede estar vacio")
    private String motivo_consulta;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "el campo del box no puede estar vacio")
    private String Box;
}
