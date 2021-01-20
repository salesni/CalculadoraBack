package com.deloitte.app.op.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.app.op.client.OperationsDataClient;
import com.deloitte.app.op.model.OperationClient;
import com.deloitte.app.op.operations.table.OperationsData;


@Service("ServiceFeign")

public class OperationsDataServiceFeign  implements IOperationsDataService{
	
	@Autowired
	private OperationsDataClient clienteFeign;

	@Override
	public List<OperationClient> listar() {
		 System.out.println("Hola");
		 List<OperationClient> listClient = new LinkedList<OperationClient>();
		 List<OperationsData> list =clienteFeign.listar();
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
		 
				//.stream().map(op ->
//		new OperationClient(
//		op.getId(),
//		op.getId_operation().getId(),
//		op.getId_usuario().getId(),
//		op.getOperation(),
//		op.getAnswer() )
//		{ 
//			OperationClient item = new OperationClient();
//			
//			item.setId(op.getId());
//			item.setOp_id(op.getId_operation().getId());
//			item.setUs_id(op.getId_usuario().getId());
//			item.setAnswer(op.getAnswer());
//			item.setOperation(op.getOperation());
//			return item;
//		}
		//).peek(imprimir -> System.out.println(imprimir.getAnswer())).collect(Collectors.toList());

		
	}



	@Override
	public OperationsData crear(OperationsData producto) {
		
		
		return null;
	}

	@Override
	public OperationsData update(OperationsData producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
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
	public OperationClient detalleByOperation(String operation) {
		// TODO Auto-generated method stub
		return null;
	}

}
