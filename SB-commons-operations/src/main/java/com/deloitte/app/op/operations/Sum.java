package com.deloitte.app.op.operations;

import java.util.ArrayList;
import java.util.List;

public class Sum{
	
	private Integer id =1;
	private List<Double> numbers;
	private String operation;
	private Double answer;
	private int cont;
	
	public Sum() {}
	
	
	
	private void sum() {
		if(answer == null) {
			answer=0.0;
			numbers.forEach(number -> {
				answer+=number;
			});
		}
	}
	
	
	private void stringConv() {
		if(operation == null) {
			operation="";
			cont=0;
			numbers.forEach(number -> {
				cont++;
				if(this.cont<this.numbers.size()) {
					operation+= ("("+number.toString()+")+");
				}
				else {
					operation+= ( "("+number.toString()+")");
				}
			});
			operation+= ("="+ this.getAnswer().toString());
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Double> getNumbers() {
		return numbers;
	}
	public void setNumbers(List<Double> numbers) {
		this.numbers = numbers;
	}
	
	
	public String getOperation() {
		stringConv();
		return operation;
	}
	
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	
	public Double getAnswer() {
		sum();
		return answer;
	}
	
	public void setAnswer(Double answer) {
		this.answer = answer;
	}
	
//	public static void main(String[] args) {
//		Sum skere = new Sum();
//		List<Double> lista = new ArrayList<Double>();
//		lista.add(-5.5);
//		lista.add(-6.25);
//		lista.add(0.25);
//		skere.setNumbers(lista);
//		System.out.println(skere.getAnswer());
//		System.out.println(skere.getAnswer());
//		System.out.println(skere.getOperation());
//		System.out.println(skere.getOperation());	
//	}


}
