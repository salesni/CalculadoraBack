package com.deloitte.app.op.operations.table;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "operations_data")
public class OperationsData implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4224603146351629343L;


	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="id_operation", referencedColumnName="id")
	private Operations id_operation;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", referencedColumnName="id")
	private Usuario id_usuario;
	
	
	//@JoinColumn(name="operation")
	private String operation;
	
	//@JoinColumn(name="answer")
	private Double answer;

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Operations getId_operation() {
		return id_operation;
	}

	public void setId_operation(Operations id_operation) {
		this.id_operation = id_operation;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuarios) {
		this.id_usuario = id_usuarios;
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
