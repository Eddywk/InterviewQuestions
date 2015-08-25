package Others;
/*Implement int sqrt(int x).
  Compute and return the square root of x.*/
class Sqrt {
	public static int sqrt(int x) {
		if(x < 2){
			return x;
		}
		int left = 1, right = x / 2;
		/*Return last_mid if we cannot find root of x exactly*/
		int last_mid = (left + right) / 2;
		while(left <= right){
			/*Magic Number: mid = (left + right) / 2*/
			int mid = (left + right) / 2;
			/*To avoid overflow we use x / mid == mid*/
			if(x / mid == mid){
				return mid;
			}else if(x / mid > mid){
				left = mid + 1;
				last_mid = mid;
			}else{
				right = mid - 1;
			}
		}
		return last_mid;
	}
	
	public static void main(String args[]){
		System.out.println(sqrt(9));
		System.out.println(sqrt(8));
		System.out.println(sqrt(7));
		System.out.println(sqrt(4));
		System.out.println(sqrt(16));
		System.out.println(sqrt(3));
	}
}
