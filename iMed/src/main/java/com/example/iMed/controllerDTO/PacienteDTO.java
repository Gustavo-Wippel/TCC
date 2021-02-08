package com.example.iMed.controllerDTO;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.iMed.modelo.Paciente;

public class PacienteDTO {
	
	private String senha;
	private String cpf;
	
	public PacienteDTO(Paciente paciente) {
		this.senha = paciente.getSenha();
		this.cpf = paciente.getCpf();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public static List<PacienteDTO> converter(List<Paciente> pacientes) {
		return pacientes.stream().map(PacienteDTO::new).collect(Collectors.toList());
	}
	

}
