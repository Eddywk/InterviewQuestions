package DataStructure;

import java.util.Stack;

public class ParseArithmetic {
	public static double parseArithmetic(String in){
		Stack<Double> number = new Stack<Double>();
		Stack<Character> operand = new Stack<Character>();
		char[] chars = in.toCharArray();
		for(int i = 0; i < chars.length; i++){
			char c = chars[i];
			if(c == ' '){
				continue;
			}
			if('0' <= c && c <= '9'){
				number.add((double) Character.getNumericValue(c));
			}else{
				if(operand.isEmpty()){
					operand.add(c);
				}else{
					if(c == '+' || c == '-'){
						while(!operand.isEmpty()){
							double num1 = number.pop();
							double num2 = number.pop();
							double res = compute(operand.pop(), num1, num2);
							number.push(res);
						}
					}
					operand.add(c);
				}
			}
		}
		while(!operand.isEmpty()){
			char op = operand.pop();
			double num1 = number.pop();
			double num2 = number.pop();
			double res = compute(op, num1, num2);
			number.add(res);
		}
		return number.peek();
	}
	
	private static double compute(char operand, double num1, double num2){
		switch (operand){
			case '+':
				return num2 + num1;
			case '-':
				return num2 - num1;
			case '*':
				return num2 * num1;
			case '/':
				return num2 / num1;
			default:
				return 0.0;
		}
	}
	
	public static void main(String args[]){
		String input = "1 * 1 + 1 + 2 * 4 / 5 - 3 + 3 * 6 - 7";
		System.out.println(parseArithmetic(input));
	}
}
