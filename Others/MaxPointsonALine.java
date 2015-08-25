package Others;

import java.util.HashMap;

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

/*Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.*/

class MaxPointsonALine {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        int max = 1;
        for(int i = 0; i < points.length; i++){
            int same = 1;
            int curMax = 0;
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            for(int j = i + 1; j < points.length; j++){
                //Record number of duplicates
                if(points[j].y == points[i].y && points[j].x == points[i].x){
                    same++;
                    continue;
                }
                //Handle precision problem for veritical cases
                double slope = points[j].x != points[i].x ? 
                    (double)(points[j].y - points[i].y) / (points[j].x - points[i].x) : Double.MAX_VALUE;
                //Handle precision problem for horizontal cases
                slope = points[j].y == points[i].y ? 0.0 : slope;
                //Update count
                int cnt = map.containsKey(slope) ? map.get(slope) : 0;
                map.put(slope, cnt + 1);
                //Update current max
                curMax = Math.max(curMax, map.get(slope));
            }
            //Update global max
            max = Math.max(max, curMax + same);
        }
        return max;
    }
}
