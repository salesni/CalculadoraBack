package com.op.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.app.op.operations.table.OperationsData;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.op.model.OperationClient;
import com.op.services.IOperationsDataService;



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
	
	
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/operaciones/{id}")
	public OperationClient detalle(@PathVariable ( name= "id") Integer id ) {
		return itemService.detalle(id);
	}
	
	@PostMapping("/operaciones")
	@ResponseStatus(HttpStatus.CREATED)
	public OperationClient crear(@RequestBody OperationClient  item) {
		return itemService.crear(item);
	}
	
	@GetMapping("/operacionesByUserId/{id}")
	public List<OperationClient> findByUserId(@PathVariable ( name= "id") Long id ) {
		return itemService.findByIdUser(id);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable ( name= "id") Integer id ) {
		itemService.eliminar(id);
	}
	
	public OperationClient metodoAlternativo(Integer id) {
		
		OperationClient item = new OperationClient();
		item.setId(id);
		item.setOp_id(id);
		item.setAnswer(666.0);
		item.setOperation("ID_NOT_FOUND");
		item.setError(true);
		item.setFound(false);
		
		return item;
	}
	
	
}
