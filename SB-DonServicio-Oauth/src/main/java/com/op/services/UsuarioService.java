package com.op.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.deloitte.app.op.operations.table.Usuario;
import com.op.clients.UsuarioFeignClient;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service("ServiceFeign")
public class UsuarioService implements IUsuarioService ,UserDetailsService {
	
	private Logger log = LoggerFactory.getLogger(Usuario.class);
	
	@Autowired
	private UsuarioFeignClient client;
	

	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = client.findByUsername(username);
		
		if(usuario == null) {
			log.error("Error en el login, no existe el usuario "+username+ " en el sistema");
			throw new UsernameNotFoundException("Error en el login, no existe el usuario "+username+ " en el sistema");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
				.peek(authority -> log.info("Role: "+ authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(),usuario.getPassword(),usuario.getEnabled(), true,true,true,authorities );
	}


	@Override
	public Usuario findByUsername(String username) {
		 return client.findByUsername(username);
	}


	@Override
	public Usuario update(Usuario usuario, Long id) {
		return client.update(usuario, id);
	}


	@Override
	public List<Usuario> list() {
		
		return client.list();
	}


	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return client.findById(id);
	}





	@Override
	public Usuario create(Usuario usuario) {
		
		//usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		
		return client.create(usuario);
	}



	@Override
	public void delete(Long id) {
		client.delete(id);
		
	}

}