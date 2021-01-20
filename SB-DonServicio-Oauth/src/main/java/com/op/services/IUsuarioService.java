package com.op.services;

import java.util.List;



import com.deloitte.app.op.operations.table.Usuario;

public interface IUsuarioService {
	public List<Usuario> list ();
	
	
	public Usuario findById (  Long id);
	

	public Usuario findByUsername (  String username);
	
	

	public Usuario create (  Usuario usuario);
	

	public Usuario update ( Usuario usuario,  Long id);
	
	

	public void delete ( Long id);
}
