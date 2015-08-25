package Others;

import java.util.HashMap;

class FractiontoRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if((numerator < 0) ^ (denominator < 0)){
            sb.append("-");
        }
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        sb.append(Long.toString(n / d));
        if(n % d == 0){
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> hash = new HashMap<Long, Integer>();
        long r = n % d;
        while(r > 0){
            if(hash.containsKey(r)){
                sb.insert(hash.get(r), "(");
                sb.append(")");
                break;
            }
            hash.put(r, sb.length());
            r *= 10;
            sb.append(Long.toString(r / d));
            r %= d;
        }
        return sb.toString();
    }
    
    public static void main(String args[]){
    	System.out.println(fractionToDecimal(1, 99));
    }
}
