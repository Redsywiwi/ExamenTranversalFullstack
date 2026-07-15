package com.hospital_vm_cl.hospital_vm.Service;

import com.hospital_vm_cl.hospital_vm.Model.Paciente;
import com.hospital_vm_cl.hospital_vm.Repository.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteServiceTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    @Test
    void debeListarPacientes() {

        Paciente paciente = new Paciente(
                1,
                "12345678-9",
                "Juan",
                "Pérez",
                LocalDate.of(2000,1,1),
                "juan@gmail.com",
                987654321,
                "Santiago",
                LocalDate.now()
        );

        when(pacienteRepository.findAll())
                .thenReturn(List.of(paciente));

        List<Paciente> resultado = pacienteService.findAll();

        assertEquals(1, resultado.size());
        assertEquals("Juan", resultado.get(0).getNombre());

        verify(pacienteRepository).findAll();
    }
}