package com.op.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.app.op.operations.table.Usuario;
import com.op.services.IUsuarioService;

@RefreshScope
@RestController
public class UsuarioController {
	@Autowired
	@Qualifier("ServiceFeign")
	private IUsuarioService service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
//	@PostMapping("/newUser")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Usuario crear(@RequestBody Usuario  usuario) {
//		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
//		return service.create(usuario);
//	}

}
