package com.example.iMed.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.example.iMed.controller.form.AtualizacaoMedicoForm;
import com.example.iMed.controller.form.MedicoForm;
import com.example.iMed.controllerDTO.MedicoDTO;
import com.example.iMed.modelo.Medico;
import com.example.iMed.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	MedicoRepository medicoRepository;
	
	@GetMapping
	public List<MedicoDTO> listar(String id) {
		List<Medico> medicos = medicoRepository.findAll();
		return MedicoDTO.converter(medicos);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<MedicoDTO> cadastrar(@RequestBody MedicoForm medicoForm, UriComponentsBuilder UriBuilder) {
		Medico medico = medicoForm.converter();
		medicoRepository.save(medico);
		
		URI uri = UriBuilder.path("medicos/{medicoId}").buildAndExpand(medico.getMedicoId()).toUri();
		
		return ResponseEntity.created(uri).body(new MedicoDTO(medico));
	}
	
	@PutMapping("/{medicoId}")
	@Transactional
	public ResponseEntity<MedicoDTO> atualizar(@PathVariable String medicoId, @RequestBody AtualizacaoMedicoForm medicoForm) {
		Medico medico = medicoForm.atualizar(medicoId, medicoRepository);
		
		return ResponseEntity.ok(new MedicoDTO(medico));
	}
	
	@DeleteMapping("/{medicoId}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable String medicoId) {
		medicoRepository.deleteById(medicoId);
		
		return ResponseEntity.ok().build();
	}
}
