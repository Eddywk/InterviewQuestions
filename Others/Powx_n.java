package Others;

/*Implement pow(x, n).*/
class Powx_n {
	/*Idea: Using divide & conquer, x^n = (x^(n/2))^2,
	 *so, we just need to keep getting x^(n/2)*/
	public double pow(double x, int n) {
		if(n < 0){
			return 1.0 / power(x, -n);
		}else{
			return power(x, n);
		}
	}
	
	private double power(double x, int n){
		if(n == 0){
			return 1;
		}
		double v = power(x, n / 2);
		if(n %  2 == 0){
			return v * v;
		}else{
			return v * v * x;
		}
	}
}
