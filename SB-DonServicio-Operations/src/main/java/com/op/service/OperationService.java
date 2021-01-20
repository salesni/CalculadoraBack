package com.op.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.app.op.operations.table.OperationsData;
import com.op.repository.OperationDataRepository;
@Service
public class OperationService implements IOperationService {
	
	@Autowired
	private OperationDataRepository repo;

	@Override
	public List<OperationsData> findAll() {
		
		return (List<OperationsData>)repo.findAll();
	}

	@Override
	public OperationsData findById(Integer id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public OperationsData save(OperationsData operationData) {
	
		return repo.save(operationData);
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public OperationsData findByOperation(String operation) {
		
		return repo.findByOperation(operation);
	}

	@Override
	public List<OperationsData> findByUserId(Integer id) {
		
		return repo.obtenerPorUserId(id);
	}

}
