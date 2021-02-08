package com.example.iMed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.iMed.controllerDTO.AreaDTO;
import com.example.iMed.modelo.Area;
import com.example.iMed.repository.AreaRepository;

@RestController
public class AreaController {
	
	@Autowired
	private AreaRepository areaRepository;
	
	@RequestMapping(value = "/areas", method = RequestMethod.GET)
	public List<AreaDTO> listar(String id) {
		List<Area> areas = areaRepository.findAll();
		return AreaDTO.converter(areas);
	}
}
