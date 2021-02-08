package com.example.iMed.controllerDTO;

import java.util.List;
import java.util.stream.Collectors;

import com.example.iMed.modelo.Area;
import com.example.iMed.modelo.Medico;

public class MedicoDTO {
	
	private String medicoId;
	private String nome;
	private String areaId;
	private int horariosDisp;
	
	public MedicoDTO (Medico medico) {
		setMedicoId(medico.getMedicoId());
		setNome(medico.getNome());
		setAreaId(medico.getAreaId());
		setHorariosDisp(medico.getHorariosDisp());
	}

	// Getters
	public String getMedicoId() {
		return this.medicoId;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getAreaId() {
		return this.areaId;
	}
	
	public int getHorariosDisp() {
		return this.horariosDisp;
	}

	
	// Setters
	public void setMedicoId(String medicoId) {
		this.medicoId = medicoId;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	
	public void setHorariosDisp(int horarios) {
		this.horariosDisp = horarios;
	}
	
	public static List<MedicoDTO> converter(List<Medico> medicos) {
		return medicos.stream().map(MedicoDTO::new).collect(Collectors.toList());
	}
}
