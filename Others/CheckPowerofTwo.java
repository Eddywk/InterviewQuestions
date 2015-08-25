package Others;
/*Check if a number is power of 2*/
class CheckPowerofTwo {
	/*Idea: check if x & (x - 1) == 0
	 * 		x = 8: 1 0 0 0
	 *   x -1 = 7: 0 1 1 1
	 *      x = 6: 0 1 1 0*/
	public static boolean isPowOfTwo(int x){
		if(x <= 0){
			return false;
		}
		
		if(((x - 1) & x) == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String args[]){
		int x = 4;
		if(isPowOfTwo(x)){
			System.out.println(x + " is power of 2!");
		}else{
			System.out.println(x + " is not power of 2!");

		}
	}
}
