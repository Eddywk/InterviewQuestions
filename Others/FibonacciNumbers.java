package Others;

class FibonacciNumbers {
	/*Version 1: Recursion*/
	public int getFibonacci(int num){
		if(num == 1 || num == 2){
			return 1;
		}
		return getFibonacci(num - 1) + getFibonacci(num - 2);
	}
	
	/*Version 2: Traverse*/
	public int getFibonacci2(int num){
		if(num == 1 || num == 2){
			return 1;
		}
		int f1 = 1, f2 = 1, f = 1;
		for(int i = 3; i <= num; i++){
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
		return f;
	}
}
