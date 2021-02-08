package com.example.iMed.controller.form;

import com.example.iMed.modelo.Consulta;
import com.example.iMed.modelo.Medico;
import com.example.iMed.repository.ConsultaRepository;
import com.example.iMed.repository.MedicoRepository;

public class AtualizacaoMedicoForm {

	private String areaId;
	
	public String getAreaId() {
		return this.areaId;
	}
	
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	
	public Medico atualizar(String medicoId, MedicoRepository medicoRepository) {
		Medico medico = medicoRepository.getOne(medicoId); 
		medico.setAreaId(areaId);
		
		return medico;
	}
}
