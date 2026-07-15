package com.hospital_vm_cl.hospital_vm.Repository;

import com.hospital_vm_cl.hospital_vm.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Long>{

}
//es la linea de comunicacion entre la aplicacion y pacientes de mi bd
//esto es basicamente para acortar el codigo repetititvo y hacer un poco menos manual el
//select, delete, find, etc
