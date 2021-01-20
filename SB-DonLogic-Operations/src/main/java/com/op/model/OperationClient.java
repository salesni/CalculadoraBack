package com.op.model;

import java.util.List;

public class OperationClient {
	
	private Integer id;
	private Integer op_id;
	private Long us_id;
	private String operation;
	private Double answer;
	private List<Double> numbers;
	private Double base;
	private int cont;
	private boolean error=false;
	private boolean isFound=false;
	
	
	
	public OperationClient() {}
	
	
	
	public OperationClient(Integer id, Integer op_id, Long us_id, List<Double> numbers, Double base) {
		this.id = id;
		this.op_id = op_id;
		this.us_id = us_id;
		this.numbers = numbers;
		this.base = base;
		this.getAnswer();
		this.getOperation();
	}
	
	


	public OperationClient(Integer op_id, Long us_id, String operation, Double answer) {
		this.op_id = op_id;
		this.us_id = us_id;
		this.operation = operation;
		this.answer = answer;
	}
	
	private void codeError(String str) {
		System.out.println("eNTRRE XD");
		this.error=true;
		this.answer=1.0;
		this.operation=str;
	}

	private void sum() {
		
		if(answer == null) {
			switch(op_id) {
				case 1:
					answer=0.0;
					numbers.forEach(number -> {
						answer+=number;
					});
					break;
				case 2:
					answer=0.0;
					numbers.forEach(number -> {
						answer-=number;
					});
					break;
				case 3:
					cont=0;
					numbers.forEach(number -> {
						cont++;
						if(this.cont==1) {
							answer=number;
						}
						else {
							if(number!=0.0 && error==false)
								answer/=number;
							else 
								codeError("ERROR_DIVITION WITH 0 NOT ALLOWED");
						}
					});
					break;
					
				case 4:
					answer=1.0;
					numbers.forEach(number -> {
						answer*=number;
					});
					break;
				
				case 5: 
					answer=0.0;
					numbers.forEach(number -> {
						answer+=number;
					});
					if(answer>=0.0)
						answer=Math.sqrt(answer);
					else 
						codeError("ERROR_SQRT CANNOT BE NEGATIVE");
					break;
				case 6:
					answer=0.0;
					numbers.forEach(number -> {
						answer+=number;
					});
					if(answer>0)
						answer=Math.log10(answer);
					else
						codeError("ERROR_LOG10 CANNOT HAVE NEGATIVE NUMBERS OR 0");
					break;
				
				case 7:
					answer=0.0;
					numbers.forEach(number -> {
						answer+=number;
					});
					answer=Math.exp(answer);
					break;
					
				case 8: 
					answer=0.0;
					numbers.forEach(number -> {
							answer+=number;
					});
					if(base!=0 && answer!=0)
						answer=Math.pow(base, answer);
					else
						codeError("ERROR_POW 0^0 NOT ALLOWED");
					
					break;
			}

		}
	}
	
	
	private void stringConv() {
		if(operation == null) {
			switch(op_id) {
				case 1:
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
					break;
				case 2:
					operation="-";
					cont=0;
					numbers.forEach(number -> {
						cont++;
						if(this.cont<this.numbers.size()) {
							operation+= ("("+number.toString()+")-");
						}
						else {
							operation+= ("("+number.toString()+")");
						}
					});
					operation+= ("=" +this.getAnswer().toString());
					break;
				case 3:
					operation="";
					cont=0;
					numbers.forEach(number -> {
						cont++;
						if(this.cont<this.numbers.size()) {
							operation+= ("("+number.toString()+")/");
						}
						else {
							operation+= ( "("+number.toString()+")");
						}
					});
					operation+= ("="+ this.getAnswer().toString());
					break;
					
				case 4:
					operation="";
					cont=0;
					numbers.forEach(number -> {
						cont++;
						if(this.cont<this.numbers.size()) {
							operation+= ("("+number.toString()+")*");
						}
						else {
							operation+= ("("+number.toString()+")");
						}
					});
					operation+= ("=" +this.getAnswer().toString());
					break;
				
				case 5: 
					operation="√(";
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
					operation+= (")="+ this.getAnswer().toString());
					break;
				case 6:
					operation="LOG(";
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
					operation+= (")="+ this.getAnswer().toString());
					break;
				
				case 7:
					operation="e^(";
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
					operation+= (")="+ this.getAnswer().toString());
					break;
					
				case 8: 
					operation=base.toString()+"^(";
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
					operation+= (")="+ this.getAnswer().toString());
					break;
			}
			
		}
	}
	
	
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getBase() {
		return base;
	}


	public void setBase(Double base) {
		this.base = base;
	}


	public Integer getOp_id() {
		return op_id;
	}
	public void setOp_id(Integer op_id) {
		this.op_id = op_id;
	}
	public Long getUs_id() {
		return us_id;
	}
	public void setUs_id(Long us_id) {
		this.us_id = us_id;
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


	public List<Double> getNumbers() {
		return numbers;
	}


	public void setNumbers(List<Double> numbers) {
		this.numbers = numbers;
	}



	public boolean isError() {
		return error;
	}



	public void setError(boolean error) {
		this.error = error;
	}



	public boolean isFound() {
		return isFound;
	}



	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}
	

}
