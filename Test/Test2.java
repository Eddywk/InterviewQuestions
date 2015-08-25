package Test;

import java.util.ArrayList;
import java.util.Collections;

import DataStructure.FindMedianWithTwoHeaps;

interface fly{
	final double pi = 3.14;
	static final double num = 2.222;
	double x = 1.0;
}

class Test2 {
	
	private static String wordSplit(String s){
		StringBuilder sb = new StringBuilder();
		String[] words = s.split(" ");
		for(String word : words){
			if(letterNum(word) >= 4 && letterNum(word) % 2 == 0){
				String[] parts = splitByTwo(word);
				for(String part : parts){
					sb.append(part).append(" ");
				}
			}else{
				sb.append(word).append(" ");
			}
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
	
	private static String[] splitByTwo(String s){
		char[] chars = s.toCharArray();
		String[] result = new String[2];
		char[] part1 = new char[s.length() / 2];
		char[] part2 = new char[s.length() - s.length() / 2];
		for(int i = 0; i < s.length(); i++){
			if(i < s.length() / 2){
				part1[i] = s.charAt(i);
			}else{
				part2[i - s.length() / 2] = s.charAt(i);
			}
		}
		result[0] = new String(part1);
		result[1] = new String(part2);
		return result;
	}
	
	private static int letterNum(String s){
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(Character.isAlphabetic(s.charAt(i))){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String args[]){
		String s = "A dog can't walk in off the street and order a large soda.";
		System.out.println(wordSplit(s));
//		String[] result = splitByTwo("can't");
//		for(String str : result){
//			System.out.println(str);
//		}
	}
}
