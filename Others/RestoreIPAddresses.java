package Others;

import java.util.ArrayList;
import java.util.List;

class RestoreIPAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() <= 3 || s.length() > 12){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(result, sb, s, 0, 0);
        return result;
    }
    
    private static void helper(List<String> result, StringBuilder sb, String s, int pos, int step){
        if(pos == s.length() && step == 4){
            result.add(sb.toString());
            System.out.println(sb.toString());
            return;
        }
        
        if(pos < s.length() && step == 4){
        	return;
        }
        
        for(int i = pos + 1; i <= s.length() && i <= pos + 3; i++){
        	String cur = s.substring(pos, i);
        	int oldLength = sb.length();
        	if(isValid(cur)){
        		if(step == 3){
        			sb.append(cur);
        		}else{
        			sb.append(cur).append('.');
        		}
        		helper(result, sb, s, i, step + 1);
        		sb.setLength(oldLength);
        	}
        }
    }
    
    private static boolean isValid(String s){
        if(s.length() < 1 || s.length() > 3){
            return false;
        }
        int val = Integer.parseInt(s);
        if(s.charAt(0) == '0' && s.length() > 1){
            return false;
        }
        if(val > 255){
            return false;
        }
        return true;
    }
    
    public static void main(String args[]){
    	String s = "0000";
    	restoreIpAddresses(s);
    }
}
