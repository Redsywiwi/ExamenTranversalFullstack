package com.hospital_vm_cl.hospital_vm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital_vm_cl.hospital_vm.Model.Medico;
import com.hospital_vm_cl.hospital_vm.Repository.MedicoRepository;
import java.util.List;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MedicoService {
    @Autowired
        private MedicoRepository medicoRepository;

    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }

    public Medico findById(long id){
        return medicoRepository.findById(id).get();
    }

    public Medico save(Medico medico){
        return medicoRepository.save(medico);
    }

    public void delete(long id){
        medicoRepository.deleteById(id);
    }
}
