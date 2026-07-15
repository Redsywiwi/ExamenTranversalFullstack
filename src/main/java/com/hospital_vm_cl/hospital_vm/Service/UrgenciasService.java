package com.hospital_vm_cl.hospital_vm.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital_vm_cl.hospital_vm.Model.Urgencias;
import com.hospital_vm_cl.hospital_vm.Repository.UrgenciasRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UrgenciasService {
    
    @Autowired
    private UrgenciasRepository urgenciasRepository;

    public List<Urgencias> findAll(){
        return urgenciasRepository.findAll();
    }

    public Urgencias findById(long id){
        return urgenciasRepository.findById(id).get();
    }

    public Urgencias save(Urgencias urgencias){
        return urgenciasRepository.save(urgencias);
    }

    public void delete(long id){
        urgenciasRepository.deleteById(id);
    }
}
