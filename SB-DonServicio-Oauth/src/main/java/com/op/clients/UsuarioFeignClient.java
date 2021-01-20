package com.op.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.deloitte.app.op.operations.table.Usuario;

@FeignClient( name = "servicio-usuarios")
public interface UsuarioFeignClient {
	
	@GetMapping( "/usuarios")
	public List<Usuario> list ();
	
	
	@GetMapping( "/usuarios/{id}")
	public Usuario findById (  @PathVariable Long id);
	
	@GetMapping( "/usuarios/search/buscar-username")
	public Usuario findByUsername ( @RequestParam String username);
	
	
	@PostMapping( "/usuarios")
	public Usuario create ( @RequestBody Usuario usuario);
	
	@PutMapping( "/usuarios/{id}")
	public Usuario update ( @RequestBody Usuario usuario, @PathVariable Long id);
	
	
	@DeleteMapping( "/usuarios/{id}")
	public void delete (@PathVariable Long id);
	
}
