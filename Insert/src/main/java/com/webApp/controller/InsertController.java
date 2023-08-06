package com.webApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webApp.DAO.InsertDAO;
import com.webApp.DTO.DisplayDTO;
import com.webApp.DTO.InputData;

@RestController
@CrossOrigin
public class InsertController {

	@Autowired
	InsertDAO insertdao;

	@RequestMapping(value = "pushData", method = RequestMethod.POST)
	public List<DisplayDTO> insert(@RequestBody InputData inputdata) {
		System.out.println("insert");

		if (!inputdata.getName().equals("") && !inputdata.getRollNo().equals("")) {
			insertdao.insertUserData(inputdata);
			System.out.println(inputdata.getName());
		} else {
			System.out.println("not data is passed");
		}

		List<DisplayDTO> displayData = insertdao.loadInfo();
		for (DisplayDTO data : displayData) {
			System.out.println(data.getSno());
		}
		return displayData;
	}

	@RequestMapping(value = "displayData", method = RequestMethod.GET)
	public List<DisplayDTO> display(DisplayDTO infodto) {
		System.out.println("Display");
		List<DisplayDTO> displayData = insertdao.loadInfo();
		for (DisplayDTO data : displayData) {
			System.out.println(data.getSno());
		}
		return displayData;
	}

}
