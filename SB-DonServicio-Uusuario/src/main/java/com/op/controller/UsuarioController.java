package com.op.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.deloitte.app.op.operations.table.Usuario;
import com.op.service.IUserService;


@RefreshScope
@RestController
public class UsuarioController {
	@Autowired
	@Qualifier("ServiceFeign")
	private IUserService service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@PostMapping("/newUser")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario  usuario) {
		System.out.println(usuario.getPassword());
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		System.out.println(usuario.getPassword());
		return service.save(usuario);
	}
	
	@PutMapping("/updatePassword/{username}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario updatePassword(@RequestBody Usuario  usuario, @PathVariable (name = "username") String username) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return service.updatePassword(usuario, username);
	}
	
	@PutMapping("/updateRoles/{username}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario updateRoles(@RequestBody Usuario  usuario, @PathVariable (name = "username") String username) {
		return service.updateRoles(usuario, username);
	}
	

}
