package com.example.iMed.controller.form;

import com.example.iMed.modelo.Paciente;
import com.example.iMed.repository.PacienteRepository;

public class AtualizacaoPacienteForm {

	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Paciente atualizar(String idPaciente, PacienteRepository pacienteRepository) {
		Paciente paciente = pacienteRepository.getOne(idPaciente);
		paciente.setSenha(this.senha);
		
		return paciente;
	}
	
}
