package com.op.service;

import com.deloitte.app.op.operations.table.Usuario;

public interface IUserService {
	public Usuario save(Usuario usuario);
	public Usuario updatePassword(Usuario usuario, String username);
	public Usuario updateRoles(Usuario usuario, String username);
}
