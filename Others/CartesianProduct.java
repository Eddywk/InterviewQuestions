package Others;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Kang Wang
 *
 */
class CartesianProduct {
	/**
	 * API function for getting Cartesian products
	 * 
	 * @param lists input sets
	 * @return
	 */
	public static List<List<String>> getCartesianProduct(List<List<String>> lists){
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> product = new ArrayList<String>();
		helper(lists, result, product);
		return result;
	}
	/**
	 * Recursive helper function
	 * 
	 * @param lists input sets
	 * @param result the result set of all Cartesian products
	 * @param product buffer list for product
	 */
	private static void helper(List<List<String>> lists, List<List<String>> result, List<String> product){
		//Return condition
		if(product.size() == lists.size()){
			//Copy product to result sets
			result.add(new ArrayList<String>(product));
			return;
		}
		//Locate current row we are dealing with
		List<String> list = lists.get(product.size());
		for(int i = 0; i < list.size(); i++){
			//Picking an element from current row
			product.add(list.get(i));
			//Recursive call
			helper(lists, result, product);
			//Removing the last element from buffer product
			product.remove(product.size() - 1);
		}
	}
	
	/**
	 * print all products by line
	 * 
	 * @param lists result sets
	 */
	private static void print(List<List<String>> lists){
		for(List<String> list : lists){
			for(String s : list){
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		List<List<String>> sets = new ArrayList<List<String>>();
		List<String> set1 = new ArrayList<String>();
		List<String> set2 = new ArrayList<String>();
		List<String> set3 = new ArrayList<String>();
		sets.add(set1);
		sets.add(set2);
		sets.add(set3);
		set1.add("A1"); set1.add("A2"); set1.add("A3");
		set2.add("B1"); set2.add("B2");
		set3.add("C1"); set3.add("C2");
		List<List<String>> res = getCartesianProduct(sets);
		System.out.println("Numbers of Result = " + res.size());
		print(res);
	}
}
