package com.example.iMed.controllerDTO;

import java.util.List;
import java.util.stream.Collectors;

import com.example.iMed.modelo.Consulta;
import com.example.iMed.modelo.Medico;

public class ConsultaDTO {

	private String descricao;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private String medicoId;
	private String pacienteId;
	
	public ConsultaDTO (Consulta consulta) {
		setDescricao(consulta.getDescricao());
		setMes(consulta.getMes());
		setDia(consulta.getDia());
		setHora(consulta.getHora());
		setMinuto(consulta.getMinuto());
		setMedicoId(consulta.getMedicoId());
		setPacienteId(consulta.getPacienteId());
	}

	// Getters
	public String getDescricao( ) {
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
	
	public static List<ConsultaDTO> converter(List<Consulta> consultas) {
		return consultas.stream().map(ConsultaDTO::new).collect(Collectors.toList());
	}
}
