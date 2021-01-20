package com.op.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.app.op.operations.table.Usuario;
import com.op.repository.UsuarioRepository;


@Service("ServiceFeign")
public class UserService implements IUserService {
	@Autowired
	private UsuarioRepository repo;

	@Override
	public Usuario save(Usuario usuario) {
		
		return repo.save(usuario);
	}

	@Override
	public Usuario updatePassword(Usuario usuario, String username) {
		Usuario newUser = repo.findByUsername(username);
		newUser.setPassword(usuario.getPassword());
		return repo.save(newUser);
	}

	@Override
	public Usuario updateRoles(Usuario usuario, String username) {
		Usuario newUser = repo.findByUsername(username);
		newUser.setRoles(usuario.getRoles());
		return repo.save(newUser);
	}

}
