package ArrayandString;

import java.util.Arrays;

class RemoveDuplicatesFromCharArray {
    //Version 1: Sort & In-place
    public static int removeDuplicates1(char[] chars){
        if(chars == null || chars.length <= 1){
            return 1;
        }
        Arrays.sort(chars);
        int index = 1;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == chars[i - 1]){
                continue;
            }
            chars[index++] = chars[i];
        }
        return index;
    }
    
    //Version 2: Constant space & In-place
    public static int removeDuplicates2(char[] chars){
        if(chars == null || chars.length <= 1){
            return 1;
        }
        boolean[] hash = new boolean[256];
        int index = 0;
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(hash[c]){
                continue;
            }
            hash[c] = true;
            chars[index++] = c;
        }
        for(int i = 0; i < index; i++){
        	System.out.print(chars[i] + " ");
        }
        System.out.println();
        return index;
    }
    
    //Version 3: Unsorted & In-place
    public static int removeDuplicates3(char[] chars){
        if(chars == null || chars.length <= 1){
            return 1;
        }        
        int index = 0;
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            boolean isDup = false;
            for(int j = 0; j < index; j++){
                if(chars[j] == c){
                    isDup = true;
                    break;
                }
            }
            if(!isDup){
                chars[index++] = c;
            }
        }
        for(int i = 0; i < index; i++){
        	System.out.print(chars[i] + " ");
        }
        System.out.println();
        return index;
    }
    
    public static void main(String args[]){
    	char[] tc1 = {'a','a'};
    	char[] tc2 = {'a','b'};
    	char[] tc3 = {'a'};
    	char[] tc4 = {'a','b','a','c','d','b'};
//    	System.out.println(removeDuplicates1(tc1));
//    	System.out.println("-----------------");
//    	System.out.println(removeDuplicates2(tc4));
//    	System.out.println("-----------------");
    	System.out.println(removeDuplicates3(tc4));
    	System.out.println("-----------------");
    }
}
