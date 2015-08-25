package ArrayandString;

class IntegertoRoman {
    public static String intToRoman(int num) {
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" }; 
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };  
        String result = "";
        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                num -= values[i];
                result += numerals[i];
            }
        }
        return result;
    }
    
    public static void main(String args[]){
    	System.out.println(intToRoman(3000));
    }
}
