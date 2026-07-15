package com.hospital_vm_cl.hospital_vm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm_cl.hospital_vm.Model.FichasClinicas;
import com.hospital_vm_cl.hospital_vm.Repository.FichasClinicasRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FichasClinicasService {
    @Autowired
        private FichasClinicasRepository fichasClinicasRepository;

    public List<FichasClinicas> findAll(){
        return fichasClinicasRepository.findAll();
    }

    public FichasClinicas findById(long id){
        return fichasClinicasRepository.findById(id).get();
    }

    public FichasClinicas save(FichasClinicas fichasClinicas){
        return fichasClinicasRepository.save(fichasClinicas);
    }

    public void delete(long id){
        fichasClinicasRepository.deleteById(id);
    }
}
