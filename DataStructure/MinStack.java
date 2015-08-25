package DataStructure;

import java.util.Stack;

class MinStack {
    static Stack<Integer> stack = new Stack<Integer>();
    static Stack<Integer> minStack = new Stack<Integer>();
    public MinStack() {
        // do initialize if necessary
//        stack = new Stack<Integer>();
//        minStack = new Stack<Integer>();
    }

    public static void push(int number) {
        // write your code here
        stack.push(number);
        //System.out.println("Stack push " + number);
        if(minStack.isEmpty() || number <= minStack.peek()){
            minStack.push(number);
            //System.out.println("MinStack push " + number);
        }
    }

    public static int pop() {
        // write your code here
    	//System.out.println("MinStack peek " + minStack.peek());
    	//System.out.println("Stack peek " + stack.peek());
    	
    	/*Should use equals because peek() return Integer object rather
    	 *than int, if use == their addresses can not be the same!! So, 
    	 *minStack.peek() == stack.peek() always is false!*/
        if(stack.peek().equals(minStack.peek())){
        	//System.out.println("MinStack pop " + minStack.peek());
            minStack.pop();
        }
        //System.out.println("Stack pop " + stack.peek());
        return stack.pop();
    }

    public static int min() {
        // write your code here
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
        	//System.out.println("min() " + minStack.peek());
            return minStack.peek();
        }
    }
    
    public static void main(String args[]){
    	push(152);
    	pop();
    	push(163); 
    	min();
    }
}
