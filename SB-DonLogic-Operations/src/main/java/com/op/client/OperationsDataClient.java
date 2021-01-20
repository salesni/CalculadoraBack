package com.op.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.deloitte.app.op.operations.table.OperationsData;

@FeignClient (name = "servicio-operation")
public interface OperationsDataClient {
	@GetMapping("/yaJala")
	public List<OperationsData> listar();
	
	@GetMapping("/operaciones/{id}")
	public OperationsData detalle(@PathVariable (name = "id") Integer id);
	
	@GetMapping("/byUserID/{id}")
	public List<OperationsData>findByIdUser(@PathVariable (name = "id") Long id);
	
	@PostMapping("/operaciones")
	public OperationsData crear(@RequestBody OperationsData producto);
	
	@PutMapping("/operaciones/{id}")
	public OperationsData update(@RequestBody OperationsData producto, @PathVariable Integer id); 
	
	@DeleteMapping("/operaciones/{id}")
	public void eliminar(@PathVariable Integer id);
	

}
