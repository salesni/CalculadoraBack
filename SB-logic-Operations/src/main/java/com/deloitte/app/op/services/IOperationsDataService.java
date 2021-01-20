package com.deloitte.app.op.services;

import java.util.List;

import com.deloitte.app.op.model.OperationClient;
import com.deloitte.app.op.operations.table.OperationsData;

public interface IOperationsDataService {
	
	public List<OperationClient> listar();
	
	
	public OperationClient detalle( Integer id);
	
	
	public OperationClient detalleByOperation( String operation);;
	
	public OperationsData crear( OperationsData producto);
	

	public OperationsData update( OperationsData producto); 
	
	public void eliminar( Integer id);

}
