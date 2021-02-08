package com.example.iMed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iMed.modelo.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, String>{
	
}
