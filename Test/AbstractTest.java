package Test;

abstract class AbstractTest {
	String name;
	public AbstractTest(String s){
		name = s;
	}
	
	abstract void getName();
}
