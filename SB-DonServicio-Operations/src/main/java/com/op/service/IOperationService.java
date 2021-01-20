package com.op.service;

import java.util.List;



import com.deloitte.app.op.operations.table.OperationsData;

public interface IOperationService {
	public List<OperationsData> findAll();
	public List<OperationsData> findByUserId(Integer id);
	public OperationsData findById(Integer id);
	public OperationsData save(OperationsData operationData);
	public void deleteById(Integer id);
	public OperationsData findByOperation( String operation);
}
