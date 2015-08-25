package Design;

import java.util.HashMap;

public class MyMath {
	public String toDecimal(int numerator, int denominator){
		if(numerator == 0){
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		
		/*Minus Sign*/
		boolean minus_sign = (numerator > 0) ^ (denominator > 0);
		sb.append(minus_sign ? "-" : "");
		/*Convert into absolute long*/
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		/*Integer part*/
		sb.append(num / den);
		num %= den;
		/*Exact Division Check*/
		if(num == 0) return sb.toString();
		/*Append dot*/
		sb.append(".");
		map.put(num, sb.length());
		
		/*Fraction Part*/
		while(num != 0){
			num *= 10;
			sb.append(num / den);
			num %= den;
			if(map.containsKey(num)){
				int index = map.get(num);
				sb.insert(index, "(");
				sb.append(")");
				break;
			}else{
				map.put(num, sb.length());
			}
		}
		
		return sb.toString();
	}
}
