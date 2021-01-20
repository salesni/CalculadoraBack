package com.deloitte.app.op.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.deloitte.app.op.operations.table.OperationsData;

@RepositoryRestResource(path = "operaciones")
public interface OperationsDataRepository   extends PagingAndSortingRepository <OperationsData, Integer>{
	
	@RestResource(path = "find-operation")
	public OperationsData findByOperation(@Param ("operation") String operation);
	
//	@Query(" select u from Usuario u where u.username=?1")
//	public Usuario obtenerporNombredeUsuario(String username);
}
