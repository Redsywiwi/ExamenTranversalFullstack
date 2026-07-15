package com.hospital_vm_cl.hospital_vm.Repository;
import com.hospital_vm_cl.hospital_vm.Model.FichasClinicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichasClinicasRepository extends JpaRepository <FichasClinicas ,Long>{
    
}
