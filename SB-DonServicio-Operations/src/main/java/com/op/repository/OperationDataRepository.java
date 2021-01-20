package com.op.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deloitte.app.op.operations.table.OperationsData;

@RepositoryRestResource(path = "operaciones")
public interface OperationDataRepository   extends PagingAndSortingRepository <OperationsData, Integer>{
	
	@RestResource(path = "find-operation")
	public OperationsData findByOperation(@RequestBody String operation);
	
	@RestResource(path = "list")
	public List<OperationsData> findAll();
	
	//@RestResource(path = "find-byUserID")
	@Query( value ="select * from my_math.operations_data  where id_usuario= :id", nativeQuery = true)
	public List<OperationsData> obtenerPorUserId(@Param("id") Integer id);
}
