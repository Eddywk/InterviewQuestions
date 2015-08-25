package Design;

import java.util.Stack;

class MinStack extends Stack<Integer>{
	private Stack<Integer> s2;
	
	public MinStack(){
		s2 = new Stack<Integer>();
	}
	
	public void push(int x){
		if(x <= min()){
			s2.push(x);
		}
		super.push(x);
	}
	
	public Integer pop(){
		int val = super.pop();
		if(val == min()){
			s2.pop();
		}
		return val;
	}
	
	public int min(){
		return s2.isEmpty() ? Integer.MAX_VALUE : s2.peek();
	}
}
