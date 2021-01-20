package com.op.services;

import java.util.List;




import com.op.model.OperationClient;

public interface IOperationsDataService {
	
	public List<OperationClient> listar();
	
	
	public OperationClient detalle( Integer id);
	
	
	public  List<OperationClient>findByIdUser( Long id);
	
	public OperationClient crear( OperationClient producto);
	

	public OperationClient update( OperationClient producto); 
	
	public void eliminar( Integer id);

}
