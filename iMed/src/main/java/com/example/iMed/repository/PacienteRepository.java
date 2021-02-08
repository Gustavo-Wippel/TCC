package com.example.iMed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iMed.modelo.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, String>{

	 
	List<Paciente> findByidPaciente(String idPaciente);
	
		
}
