package com.example.iMed.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paciente {
	
	@Id
	private String idPaciente;
	private String cpf;
	private String senha;
	private String email;
	
	public Paciente(String idPaciente, String cpf, String senha, String email) {
		setIdPaciente(idPaciente);
		setCpf(cpf);
		setSenha(senha);
		setEmail(email);
	}
	
	public Paciente() {
		
	}
	
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
	
	
	
	
	

	
	
}
