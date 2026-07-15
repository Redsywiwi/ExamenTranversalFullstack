package com.hospital_vm_cl.hospital_vm.Service;
import com.hospital_vm_cl.hospital_vm.Model.Paciente;
import com.hospital_vm_cl.hospital_vm.Repository.PacienteRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PacienteService {
    
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Paciente findById(long id){
        return pacienteRepository.findById(id).get();
    }

    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public void delete(long id){
        pacienteRepository.deleteById(id);
    }

}