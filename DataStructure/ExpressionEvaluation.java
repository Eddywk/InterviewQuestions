package DataStructure;

import java.util.Stack;

class ExpressionEvaluation {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        // write your code here
        Stack<Integer> nums = new Stack<Integer>();
        Stack<String> ops = new Stack<String>();
        for(String s : expression){
            if(s.equals("(")){
                ops.push(s);
            }else if(s.equals(")")){
                while(!ops.isEmpty() && !ops.peek().equals("(")){
                    nums.push(compute(nums, ops));
                }
                ops.pop();
            }else if(isOp(s)){
                while(!ops.isEmpty() && hasPrecedence(s, ops.peek())){
                    nums.push(compute(nums, ops));
                }
                ops.push(s);
            }else{
                nums.push(Integer.parseInt(s));
            }
        }
        while(!ops.isEmpty()){
            nums.push(compute(nums, ops));
        }
        return nums.isEmpty() ? 0 : nums.peek();
    }
    
    private int compute(Stack<Integer> nums, Stack<String> ops){
        int num1 = nums.pop();
        int num2 = nums.pop();
        String op = ops.pop();
        if(op.equals("+")){
            return num1 + num2;
        }else if(op.equals("-")){
            return num2 - num1;
        }else if(op.equals("*")){
            return num1 * num2;
        }else{
            return num2 / num1;
        }
    }
    
    private boolean isOp(String exp){
        if(exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/")){
            return true;
        }
        return false;
    }
    
    private boolean hasPrecedence(String s1, String s2){
        if(s2.equals("(")){
            return false;
        }else if((s1.equals("*") || s1.equals("/")) && (s2.equals("+") || s2.equals("-"))){
            return false;
        }else{
            return true;
        }
    }
}
