package DynamicProgramming;

class ClimbingStairs {
	/*You are climbing a stair case. It takes n steps to reach to the top.
	 *Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/
	public int climbStairs(int n) {
		if(n <= 1) return n;
		/*last means one step before now
		 *lastlast means two steps before now*/
		int last = 1, lastlast = 1;
		int now = 0;
		for(int i = 2; i <= n; i++){
			/*Key transfer function: step_n = step_n-1 + step_n-2*/
			now = last + lastlast;
			/*Keep going one step,
			 *so, the number two-step = one-step*/
			lastlast = last;
			/*one-step before become now*/
			last = now;
		}
		return now;
	}
	
	/*Version 2: DP(Good)*/
	public static int countWaysDP(int n, int[] map){
		if(n < 0){
			return 0;
		}else if(n == 0){
			return 1;
		}else if(map[n] > -1){
			return map[n];
		}else{
			map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map) + countWaysDP(n - 3, map);
			return map[n];
		}
	}
}
