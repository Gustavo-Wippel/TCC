package com.example.iMed.controller.form;

import com.example.iMed.modelo.Consulta;

public class ConsultaForm {

	private String consultaId;
	private String descricao;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private String medicoId;
	private String pacienteId;

	// Getters
	public String getConsultaId() {
		return this.consultaId;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public int getDia() {
		return this.dia;
	}

	public int getHora() {
		return this.hora;
	}

	public int getMinuto() {
		return this.minuto;
	}

	public String getMedicoId() {
		return this.medicoId;
	}

	public String getPacienteId() {
		return this.pacienteId;
	}

	
	// Setters
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setConsultaId(String consultaId) {
		this.consultaId = consultaId;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public void setMedicoId(String medicoId) {
		this.medicoId = medicoId;
	}

	public void setPacienteId(String pacienteId) {
		this.pacienteId = pacienteId;
	}
	
	public Consulta converter() {
		return new Consulta(consultaId, descricao, mes, dia, hora, minuto, medicoId, pacienteId);
	}
}
