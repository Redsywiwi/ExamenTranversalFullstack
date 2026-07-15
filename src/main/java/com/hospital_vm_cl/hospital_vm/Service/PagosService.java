package com.hospital_vm_cl.hospital_vm.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital_vm_cl.hospital_vm.Model.Pagos;
import com.hospital_vm_cl.hospital_vm.Repository.PagosRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PagosService {
    @Autowired
        private PagosRepository pagosRepository;

    public List<Pagos> findAll(){
        return pagosRepository.findAll();
    }

    public Pagos findById(long id){
        return pagosRepository.findById(id).get();
    }

    public Pagos save(Pagos pagos){
        return pagosRepository.save(pagos);
    }

    public void delete(long id){
        pagosRepository.deleteById(id);
    }
}
