package com.example.iMed.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.iMed.controller.form.AtualizacaoPacienteForm;
import com.example.iMed.controller.form.PacienteForm;
import com.example.iMed.controllerDTO.PacienteDTO;
import com.example.iMed.modelo.Paciente;
import com.example.iMed.repository.PacienteRepository;


@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@CrossOrigin
	@GetMapping
	public List<PacienteDTO> listarPacientes (String idPaciente) {
		
		if (idPaciente == null) {
			
			List<Paciente> pacientes = pacienteRepository.findAll();
			return PacienteDTO.converter(pacientes);	
			
		} else {
			List<Paciente> pacientes =  pacienteRepository.findByidPaciente(idPaciente);
			return PacienteDTO.converter(pacientes);
		}
	}

	@CrossOrigin
	@GetMapping("/{idPaciente}")
	public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable String idPaciente) {
		
		Optional<Paciente> paciente = pacienteRepository.findById(idPaciente);
		
		if (paciente.isPresent()) {
			return ResponseEntity.ok(new PacienteDTO(paciente.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PacienteDTO> cadastrar(@RequestBody PacienteForm pacienteForm, UriComponentsBuilder uriBuilder) {
		Paciente paciente = pacienteForm.converter();
		pacienteRepository.save(paciente);
		
		URI uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getIdPaciente()).toUri();
		
		return ResponseEntity.created(uri).body(new PacienteDTO(paciente)); 	
	}
	
	@CrossOrigin
	@PutMapping("/{idPaciente}")
	@Transactional
	public ResponseEntity<PacienteDTO> atualizar(@PathVariable String idPaciente, AtualizacaoPacienteForm pacienteForm) {
		Paciente paciente = pacienteForm.atualizar(idPaciente, pacienteRepository);
		
		return ResponseEntity.ok(new PacienteDTO(paciente));
		
	}
	
	@CrossOrigin
	@DeleteMapping("/{idPaciente}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable String idPaciente) {
		pacienteRepository.deleteById(idPaciente);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
}
