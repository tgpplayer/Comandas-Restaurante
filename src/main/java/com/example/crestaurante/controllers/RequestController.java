package com.example.crestaurante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crestaurante.service.RequestService;

@RestController
public class RequestController {
	
	@Autowired
	private RequestService rService;
	
	@PutMapping("/set-table-to-finished")
	public void setTableToFinished(@RequestParam int table) {
		rService.setTableToFinished(table);
	}
}
