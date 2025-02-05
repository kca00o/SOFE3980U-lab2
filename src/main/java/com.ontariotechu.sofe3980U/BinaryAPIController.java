package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/add")
	public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  Binary.add(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}
	
	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"add",number2,Binary.add(number1,number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}



	@GetMapping("/and")
	public String and(@RequestParam String operand1, @RequestParam String operand2) {
		return Binary.and(new Binary(operand1), new Binary(operand2)).getValue();
	}

	@GetMapping("/and_json")
	public BinaryAPIResult andJSON(@RequestParam String operand1, @RequestParam String operand2) {
		Binary num1 = new Binary(operand1);
		Binary num2 = new Binary(operand2);
		return new BinaryAPIResult(num1, "and", num2, Binary.and(num1, num2));
	}

	@GetMapping("/or")
	public String or(@RequestParam String operand1, @RequestParam String operand2) {
		return Binary.or(new Binary(operand1), new Binary(operand2)).getValue();
	}

	@GetMapping("/or_json")
	public BinaryAPIResult orJSON(@RequestParam String operand1, @RequestParam String operand2) {
		Binary num1 = new Binary(operand1);
		Binary num2 = new Binary(operand2);
		return new BinaryAPIResult(num1, "or", num2, Binary.or(num1, num2));
	}

	@GetMapping("/multiply")
	public String multiply(@RequestParam String operand1, @RequestParam String operand2) {
		return Binary.multiply(new Binary(operand1), new Binary(operand2)).getValue();
	}

	@GetMapping("/multiply_json")
	public BinaryAPIResult multiplyJSON(@RequestParam String operand1, @RequestParam String operand2) {
		Binary num1 = new Binary(operand1);
		Binary num2 = new Binary(operand2);
		return new BinaryAPIResult(num1, "multiply", num2, Binary.multiply(num1, num2));
	}

}