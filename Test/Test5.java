package Test;

class Test5 {
	public static boolean foo(){
		System.out.println("Called foo");
		return (true);
	}
	
	public static boolean bar(){
		System.out.println("Called bar");
		return (false);		
	}
	
	public static void main(String args[]){
		int a = 2;
		int b = 4;
		
		System.out.println(a | b);
		System.out.println(foo() | bar());
		System.out.println(foo() || bar());
	}
}
