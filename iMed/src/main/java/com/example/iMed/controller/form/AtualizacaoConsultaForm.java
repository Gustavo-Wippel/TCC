package com.example.iMed.controller.form;

import com.example.iMed.modelo.Consulta;
import com.example.iMed.repository.ConsultaRepository;

public class AtualizacaoConsultaForm {

	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private String medicoId;
	
	// Getters
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
	
	// Setters
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
	
	public Consulta atualizar(String consultaId, ConsultaRepository consultaRepository) {
		Consulta consulta = consultaRepository.getOne(consultaId); 
		consulta.setMes(this.mes);
		consulta.setDia(this.dia);
		consulta.setMes(this.mes);
		consulta.setDia(this.dia);
		consulta.setHora(this.hora);
		consulta.setMinuto(this.minuto);
		consulta.setMedicoId(this.medicoId);
		
		return consulta;
	}
}
