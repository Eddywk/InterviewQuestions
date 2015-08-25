package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import BinaryTree.BSTIterator;
import BinaryTree.TreeNode;

public class Test3 {
	
    public static String binaryRepresentation(String n) {
        // write your code here
        String[] parts = n.split("\\.");
        int L = Integer.parseInt(parts[0]);
        String left = Integer.toString(L, 2);
        double R = Double.parseDouble("." + parts[1]);
        StringBuilder sb = new StringBuilder();
        sb.append(left);
        sb.append(".");
        while(R > 0){
            if(sb.length() >= 32){
                return "ERROR";
            }
            double r = R * 2;
            if(r >= 1){
                sb.append(1);
                R = r - 1;
            }else{
                sb.append(0);
                R = r;
            }
        }
        return sb.toString();
    }
    
    public static void main(String args[]){
//    	String n = "3.72";
//    	System.out.println(binaryRepresentation(n));
//    	StringBuilder sb;
//    	Queue<Integer> heap = new PriorityQueue<Integer>(100, Collections.reverseOrder());
//    	heap.add(1);
//    	heap.add(2);
//    	System.out.println(heap.peek());
    	
    	String path = "/a/./b/../../c/";
    	String[] sections = path.split("/+");
    	for(String s : sections){
    		System.out.println(s);
    	}
    }
}
