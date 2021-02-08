package com.example.iMed.controller.form;

import com.example.iMed.modelo.Paciente;

public class PacienteForm {
	
	private String idPaciente;
	private String cpf;
	private String senha;
	private String email;
		
	public String getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Paciente converter() {
		return new Paciente(idPaciente, cpf, senha, email);
	}
	
	
}
