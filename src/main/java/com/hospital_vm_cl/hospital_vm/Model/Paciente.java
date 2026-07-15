package com.hospital_vm_cl.hospital_vm.Model;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


//cosito que extiende la clase persona pa probar que la herencia funciona
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)//esto es requisito porque el data daba drama si no lo ponia
@ToString(callSuper = true)//pasa lo mismo q lo de arriba


@Table(name= "paciente")
public class Paciente extends Persona{
    
    @Column(nullable = false)
    @NotNull(message = "La fecha de registro no puede estar vacia")
    private LocalDate fecha_registro;   //datos de esta clase

    


    public Paciente(Integer id, String run, String nombre, String apellidos, LocalDate fecha_nacimiento, String correo, Integer telefono, String direccion, LocalDate fecha_registro) {
        super(id, run, nombre, apellidos, fecha_nacimiento, correo, telefono, direccion);
        this.fecha_registro = fecha_registro;
    }   //constructor personalizado para traer los datos del abstract persona porque data y allargs constructor no los traen asi como si nada
}
