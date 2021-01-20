package com.op;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.deloitte.app.op.operations.table.Operations;
import com.deloitte.app.op.operations.table.OperationsData;
import com.deloitte.app.op.operations.table.Rol;
import com.deloitte.app.op.operations.table.Usuario;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(OperationsData.class,Usuario.class, Rol.class,Operations.class); 
	}
}