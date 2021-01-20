package com.deloitte.app.op.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.app.op.model.OperationClient;
import com.deloitte.app.op.services.IOperationsDataService;

@RefreshScope
@RestController
public class OperationItemController {
	
	
	@Autowired
	@Qualifier("ServiceFeign")
	private IOperationsDataService itemService;
	
	@GetMapping("/operaciones")
	public List<OperationClient>listar(){
		return itemService.listar();
	}
	
	@GetMapping("/operaciones/{id}")
	public OperationClient detalle(@PathVariable ( name= "id") Integer id ) {
		return itemService.detalle(id);
	}
}
