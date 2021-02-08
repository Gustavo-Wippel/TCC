package com.example.iMed.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medico {
	
	@Id
	private String medicoId;
	private String nome;
	private String cpf;
	private String rg;
	public String senha;
	public int consultas;
	public int horariosDisp;
	private String areaId;
	
	public Medico (String medicoId, String nome, String cpf, String rg, String senha, int consultas, int horariosDisp, String areaId) {
		setMedicoId(medicoId);
		setNome(nome);
		setCpf(cpf);
		setRg(rg);
		setSenha(senha);
		setConsultas(consultas);
		setHorariosDisp(horariosDisp);
		setAreaId(areaId);
	}
	
	public Medico () {
		
	}

	// Getters
	public String getMedicoId() {
		return this.medicoId;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getRg() {
		return this.rg;
	}

	public String getSenha() {
		return this.senha;
	}
	
	public int getConsultas() {
		return this.consultas;
	}
	
	public int getHorariosDisp() {
		return this.horariosDisp;
	}
	
	public String getAreaId() {
		return this.areaId;
	}

	
	// Setters
	public void setMedicoId(String medicoId) {
		this.medicoId = medicoId;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setConsultas(int consultas) {
		this.consultas = consultas;
	}
	
	public void setHorariosDisp(int horarios) {
		this.horariosDisp = horarios;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
}
