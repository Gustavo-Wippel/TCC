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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.iMed.controller.form.AtualizacaoConsultaForm;
import com.example.iMed.controller.form.ConsultaForm;
import com.example.iMed.controllerDTO.ConsultaDTO;
import com.example.iMed.modelo.Consulta;
import com.example.iMed.repository.ConsultaRepository;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@CrossOrigin
	@GetMapping
	public List<ConsultaDTO> listar(String id) {
		List<Consulta> consultas = consultaRepository.findAll();
		return ConsultaDTO.converter(consultas);
	}
	
	@CrossOrigin
	@GetMapping("/{consultaId}")
	public ResponseEntity<ConsultaDTO> buscarConsulta(@PathVariable String consultaId) {
		Optional<Consulta> consulta = consultaRepository.findById(consultaId);
		
		if(consulta.isPresent()) {
			return ResponseEntity.ok(new ConsultaDTO(consulta.get()));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@CrossOrigin
	@PostMapping
	@Transactional
	public ResponseEntity<ConsultaDTO> cadastrar(@RequestBody ConsultaForm consultaForm, UriComponentsBuilder UriBuilder) {
		Consulta consulta = consultaForm.converter();
		consultaRepository.save(consulta);
		
		URI uri = UriBuilder.path("consultas/{consultaId}").buildAndExpand(consulta.getConsultaId()).toUri();
		
		return ResponseEntity.created(uri).body(new ConsultaDTO(consulta));
	}
	
	@CrossOrigin
	@PutMapping("/{consultaId}")
	@Transactional
	public ResponseEntity<ConsultaDTO> atualizar(@PathVariable String consultaId, @RequestBody AtualizacaoConsultaForm consultaForm) {
		Consulta consulta = consultaForm.atualizar(consultaId, consultaRepository);
		
		return ResponseEntity.ok(new ConsultaDTO(consulta));
	}
	
	@CrossOrigin
	@DeleteMapping("/{consultaId}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable String consultaId) {
		consultaRepository.deleteById(consultaId);
		
		return ResponseEntity.ok().build();
	}
}	
