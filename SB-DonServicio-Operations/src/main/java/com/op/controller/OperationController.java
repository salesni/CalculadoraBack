package com.op.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.op.service.IOperationService;
import com.deloitte.app.op.operations.table.OperationsData;

@RestController
public class OperationController {
	
	
	@Autowired
	private IOperationService service;
	
	@GetMapping("/yaJala")
	public List<OperationsData> findAll() {
		return service.findAll();		
	}
	
	@GetMapping("/byUserID/{id}")
	public List<OperationsData> findByUserId(@PathVariable(name="id")Integer id) {
		return service.findByUserId(id);		
	}
	
	
	@GetMapping("/yaJala/{id}")
	public OperationsData findById(@PathVariable(name = "id") Integer id) {
		return service.findById(id);		
	}
	
	@PostMapping("/yaJala")
	@ResponseStatus(HttpStatus.CREATED )
	public OperationsData save(@RequestBody OperationsData operationsData) {
		return service.save(operationsData);		
	}
	

	
}
