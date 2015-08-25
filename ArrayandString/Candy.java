package ArrayandString;
/*There are N children standing in a line. Each child is assigned a rating value.
  You are giving candies to these children subjected to the following requirements:
  Each child must have at least one candy.
  Children with a higher rating get more candies than their neighbors.
  What is the minimum candies you must give?*/
class Candy {
	public static int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        /*increament[i] means the candy number we should increase for child i*/
        int[] increament = new int[ratings.length];
        for(int i = 0; i < increament.length; i++){
            increament[i] = 0;
        }
        /*Scan from left to right*/
        int inc = 1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                increament[i] = Math.max(inc++, increament[i]);
            }else{
                inc = 1;
            }
        }
        /*Scan from right to left*/
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                increament[i] = Math.max(inc++, increament[i]);
            }else{
                inc = 1;
            }
        }
        
        int sum = 0;
        for(int i = 0; i < increament.length; i++){
            sum += increament[i];
        }
        /*Everyone has at least one candy, so add length of ratings*/
        return sum + ratings.length;
	}
	
	public static void main(String args[]){
		int[] ratings = {1, 2, 3, 1, 4, 2};
		int[] r = {1, 2, 3, 3, 2, 1};
		System.out.println(candy(r));
	}
}
