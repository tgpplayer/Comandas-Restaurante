package com.example.crestaurante.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	// TODO: Show the tables that are not finished
	@GetMapping("/get-unfinished-tables")
	public ResponseEntity<List<Integer>> getUnfinishedTables() {
		return ResponseEntity.status(HttpStatus.OK).body(rService.getUnfinishedTables());
	}
}
