package com.op.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.deloitte.app.op.operations.table.OperationsData;
import com.deloitte.app.op.operations.table.Usuario;
import com.op.client.OperationsDataClient;
import com.op.model.OperationClient;
import com.deloitte.app.op.operations.table.Operations;


@Service("ServiceFeign")

public class OperationsDataServiceFeign  implements IOperationsDataService{
	
	@Autowired
	private OperationsDataClient clienteFeign;

	@Override
	public List<OperationClient> listar() {
		// System.out.println("Hola");
		 List<OperationClient> listClient = new LinkedList<OperationClient>();
		 List<OperationsData> list = clienteFeign.listar();
		 for(OperationsData op : list) {
			OperationClient item = new OperationClient();
			item.setId(op.getId());
			item.setOp_id(op.getId_operation().getId());
			item.setUs_id(op.getId_usuario().getId());
			item.setAnswer(op.getAnswer());
			item.setOperation(op.getOperation());
			listClient.add(item);
			System.out.println(op.getAnswer()); 
		 }
		 return listClient;
	}


	@Override
	public OperationClient crear(OperationClient producto) {
		
		
		OperationsData op = new OperationsData();
		
		Operations operation = new Operations();
		operation.setId(producto.getOp_id());
		
		Usuario user = new Usuario();
		user.setId(producto.getUs_id());
		
		op.setId_operation(operation);
		op.setId_usuario(user);
		op.setAnswer(producto.getAnswer());
		op.setOperation(producto.getOperation());
		producto.setFound(operationRepeated(producto.getOperation(), producto.getUs_id()));
		
		
		if(!producto.isError() && !producto.isFound())
			op = clienteFeign.crear(op);
		
		OperationClient item = new OperationClient();
		item.setId(op.getId());
		item.setOp_id(op.getId_operation().getId());
		item.setUs_id(op.getId_usuario().getId());
		item.setAnswer(op.getAnswer());
		item.setOperation(op.getOperation());
		item.setError(producto.isError());
		item.setFound(producto.isFound());
		
		return item;
	}


	@Override
	public void eliminar(Integer id) {
		clienteFeign.eliminar(id);
		
	}



	@Override
	public OperationClient detalle(Integer id) {
		OperationsData op = clienteFeign.detalle(id);
		OperationClient item = new OperationClient();
		item.setId(op.getId());
		item.setOp_id(op.getId_operation().getId());
		item.setUs_id(op.getId_usuario().getId());
		item.setAnswer(op.getAnswer());
		item.setOperation(op.getOperation());	
		return item;
	}






	@Override
	public OperationClient update(OperationClient producto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<OperationClient> findByIdUser(Long id) {
		
		return clienteFeign.findByIdUser(id).stream().map(op -> {
			OperationClient item = new OperationClient();
			item.setId(op.getId());
			item.setOp_id(op.getId_operation().getId());
			item.setUs_id(op.getId_usuario().getId());
			item.setAnswer(op.getAnswer());
			item.setOperation(op.getOperation());
			return item;
		}).collect(Collectors.toList());
	}
	
	
	private boolean operationRepeated(String str, Long id) {
		boolean answer=false;
		List<OperationClient> list = this.findByIdUser(id);
		for(OperationClient op : list) {
			if(op.getOperation().equals(str))
				return true;
		}
		return answer;
	}

}
