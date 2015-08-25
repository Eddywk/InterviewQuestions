package DynamicProgramming;
/*Implement regular expression matching with support for '.' and '*'.
	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.
  The matching should cover the entire input string (not partial).

  The function prototype should be:
  bool isMatch(const char *s, const char *p)

  Some examples:
	isMatch("aa","a") -> false
	isMatch("aa","aa") -> true
	isMatch("aaa","aa") -> false
	isMatch("aa", "a*") -> true
	isMatch("aa", ".*") -> true
	isMatch("ab", ".*") -> true
	isMatch("aab", "c*a*b") -> true*/
class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if(s == null){
            return p == null;
        }
        if(p == null){
            return s == null;
        }
        /*Base cases*/
        if(p.length() == 0){
            return s.length() == 0;
        }
        if(p.length() == 1){
            return p.equals(s) || (p.charAt(0) == '.' && s.length() == 1);
        }
        
        if(p.charAt(1) != '*'){
        	/*First characters are same, compare s[i + 1, end] to p[j + 1, end]*/
            if(s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')){
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }else{
            while(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
                if(isMatch(s, p.substring(2))){
                    return true;
                }
                s = s.substring(1);
            }
            /*First characters are different*/
            return isMatch(s, p.substring(2));
        }
    }
    
    public static void main(String args[]){
    	System.out.print(isMatch("eab", "c*a*b"));
    }
}
