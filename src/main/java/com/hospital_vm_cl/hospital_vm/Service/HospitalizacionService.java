package com.hospital_vm_cl.hospital_vm.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm_cl.hospital_vm.Model.Hospitalizacion;
import com.hospital_vm_cl.hospital_vm.Repository.HospitalizacionRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class HospitalizacionService {
    @Autowired
        private HospitalizacionRepository hospitalizacionRepository;

    public List<Hospitalizacion> findAll(){
        return hospitalizacionRepository.findAll();
    }

    public Hospitalizacion findById(long id){
        return hospitalizacionRepository.findById(id).get();
    }

    public Hospitalizacion save(Hospitalizacion hospitalizacion){
        return hospitalizacionRepository.save(hospitalizacion);
    }

    public void delete(long id){
        hospitalizacionRepository.deleteById(id);
    }
}
