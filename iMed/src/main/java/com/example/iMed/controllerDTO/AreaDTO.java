package com.example.iMed.controllerDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.iMed.modelo.Area;

public class AreaDTO {
	
	private String descricao;
	
	public AreaDTO(Area area) {
		setDescricao(area.getDescricao());
	}
	
	// Getters
	public String getDescricao() {
		return this.descricao;
	}
	
	// Setters
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static List<AreaDTO> converter(List<Area> areas) {
		return areas.stream().map(AreaDTO::new).collect(Collectors.toList());
	}
}
