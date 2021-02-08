package com.example.iMed.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Area {
	
	@Id
	private int id;
	private String descricao;
	
	public Area (int id, String descricao) {
		setId(id);
		setDescricao(descricao);
	}
	
	public Area () {
		
	} 
	
	// Getters
	public int getId() {
		return this.id;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
