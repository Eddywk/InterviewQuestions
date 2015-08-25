package Others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class RepeatedDNASequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i <= s.length() - 10; i++){
            int id = DNAtoInt(s.substring(i, i + 10));
            if(map.containsKey(id)){
                result.add(s.substring(map.get(id), map.get(id) + 10));
            }else{
                map.put(id, i);
            }
        }
        return result;
    }
    
    private static int DNAtoInt(String s){
        //A: 0x00 C:0x01 G:0x10 T:0x11
        int num = 0;
        for(int i = 0; i < 10; i++){
            char c = s.charAt(i);
            switch(c){
                case 'A':
                    num |= 0;
                    break;
                case 'C':
                    num |= 1;
                    break;
                case 'G':
                    num |= 2;
                    break;
                case 'T':
                    num |= 3;
                    break;
            }
            num <<= 2;
        }
        return num;
    }
    
    public static void main(String args[]){
    	String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    	List<String> res = findRepeatedDnaSequences(s);
    	for(String str : res){
    		System.out.println(str);
    	}
    }
}
