package Others;

import java.util.Arrays;

class MaximumGap {
	public static int maximumGap(int[] num) {
        int n;
        if(num == null || (n = num.length) < 2) {
            return 0;
        }
        int min = num[0];
        int max = num[0];
        for(int i : num) {
           if(i > max) {
               max = i;
           } else if(i < min) {
               min = i;
           }
        }
        double dist = (double)(max-min)/(double)(n-1);
        System.out.println(dist);
        int[] mins = new int[n-1];
        int[] maxs = new int[n-1];
        Arrays.fill(mins, -1);
        Arrays.fill(maxs, -1);
        for(int i : num) {
            int idx = (i == max ? n-2 : (int) ((i-min)/dist));
            if(mins[idx] == -1 || i < mins[idx]) {
                mins[idx] = i;
                System.out.println("mins: " + "idx = " + idx + " " + mins[idx]);
            }
            if(maxs[idx] == -1 || i > maxs[idx]) {
                maxs[idx] = i;
                System.out.println("maxs: " + "idx = " + idx + " " + maxs[idx]);
            }
        }
        print(mins);
        print(maxs);
        int prevMax = maxs[0];
        int maxGap = maxs[0]-mins[0];
        for(int i = 1; i < n-1; i++) {
            if(mins[i] == -1) {
                continue;
            }
            int gap = mins[i] - prevMax;
            if(gap > maxGap) {
                maxGap = gap;
            }
            prevMax = maxs[i];
        }
        return maxGap;
    }
	
	private static void print(int[] num){
		for(int i : num){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		int[] num = {5, -1, 1, 3, 8};
		System.out.println(maximumGap(num));
	}
}
