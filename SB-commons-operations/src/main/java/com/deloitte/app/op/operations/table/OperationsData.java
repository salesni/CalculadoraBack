package com.deloitte.app.op.operations.table;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name = "operations_data")
public class OperationsData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7976834606909065790L;

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToMany
	private Integer id_operation;
	
	@ManyToMany
	private Integer id_usuarios;
	
	private String operation;
	
	private Double answer;

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_operation() {
		return id_operation;
	}

	public void setId_operation(Integer id_operation) {
		this.id_operation = id_operation;
	}

	public Integer getId_usuarios() {
		return id_usuarios;
	}

	public void setId_usuarios(Integer id_usuarios) {
		this.id_usuarios = id_usuarios;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Double getAnswer() {
		return answer;
	}

	public void setAnswer(Double answer) {
		this.answer = answer;
	}
	
	

}
