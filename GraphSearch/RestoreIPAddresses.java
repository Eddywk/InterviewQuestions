package GraphSearch;

import java.util.ArrayList;
import java.util.List;
/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.
	For example:
	Given "25525511135",
  return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)*/
class RestoreIPAddresses {
	/*Using DFS, this problem like permutation problem. The difference is 
	 *we only need to divide the string into four sections, so we just cut string 3 times
	 *and at 4th time we add IP string into result.
	 *During the process we need to check each part of IP string is valid or not.*/
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        /*Input error checking*/
        if(s == null || s.length() > 12){
            return result;
        }
        helper(s, 0, 0, "", result);
        return result;
    }
    
    /*DFS*/
    private static void helper(String s, int pos, int step, String ip, List<String> result){
    	/*Find a acceptable answer and add it to result*/
        if(pos == s.length() && step == 4){
            result.add(ip);
            return;
        }
        /*Skip impossible one*/
        if(pos < s.length() && step == 4){
        	return;
        }
        String tmp = ip;
        /*The maximum length of each section is 3, so we set i < pos + 3,
         *and for preventing out of boundary of substring function, we need to
         *set i < s.length()*/
        for(int i = pos; i < pos + 3 && i < s.length(); i++){
            String str = s.substring(pos, i + 1);
            if(isValid(str)){
                ip += str;
                if(step == 3){
                    helper(s, i + 1, step + 1, ip, result);
                }else{
                    helper(s, i + 1, step + 1, ip + ".", result);
                }
            }
            /*Reset IP string!!*/
            ip = tmp;
        }
    }
    
    /*Checking validity of each section of IP string*/
    private static boolean isValid(String str){
    	/*Invalid length*/
        if(str == null || str.length() < 1 || str.length() > 3){
            return false;
        }
        /*Avoid adding section that its start is '0' except for single '0', like 011*/
        if(str.charAt(0) == '0' && str.length() > 1){
            return false;
        }
        /*Checking the number range*/
        int num = Integer.parseInt(str);
        if(num <= 255 && num >= 0){
            return true;
        }
        return false;
    }
    
    public static void main(String args[]){
    	String s = "010010";
    	System.out.println("0 1 2 3 4 5");
    	System.out.println("0 1 0 0 1 0");
    	restoreIpAddresses(s);
    }
}
