package com.hospital_vm_cl.hospital_vm.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital_vm_cl.hospital_vm.Model.Recetas;
import com.hospital_vm_cl.hospital_vm.Repository.RecetasRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecetasService {
    @Autowired
        private RecetasRepository recetasRepository;

    public List<Recetas> findAll(){
        return recetasRepository.findAll();
    }

    public Recetas findById(long id){
        return recetasRepository.findById(id).get();
    }

    public Recetas save(Recetas recetas){
        return recetasRepository.save(recetas);
    }

    public void delete(long id){
        recetasRepository.deleteById(id);
    }
}
