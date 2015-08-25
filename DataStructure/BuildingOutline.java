package DataStructure;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

class BuildingOutline {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
     
    static class Building implements Comparable<Building>{
        int start;
        int end;
        int height;
        public Building(int s, int e, int h){
            this.start = s;
            this.end = e;
            this.height = h;
        }
        public int compareTo(Building other){
            if(this.start < other.start){
            	return -1;
            }else if(this.start > other.start){
            	return 1;
            }else{
            	return other.height - this.height;
            }
        }
    }
    
    public static ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(buildings == null || buildings.length == 0){
            return result;
        }
        Queue<Building> heap = new PriorityQueue<Building>();
        for(int i = 0; i < buildings.length; i++){
            heap.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
        }
        while(!heap.isEmpty()){
            Building cur = heap.poll();
            System.out.println("start: " + cur.start + " end: " + cur.end + " height: " + cur.height);
            //Edge case & non-overlap
            // if(heap.isEmpty() || heap.peek().start > cur.end || heap.peek().start == cur.end && cur.height <> heap.peek().height)
            if(heap.isEmpty() || heap.peek().start > cur.end || 
            (heap.peek().start == cur.end && cur.height != heap.peek().height)){
                addResult(result, cur.start, cur.end, cur.height);
            }else if(heap.peek().start <= cur.end && cur.height == heap.peek().height){
                Building next = heap.poll();
                heap.add(new Building(cur.start, Math.max(cur.end, next.end), cur.height));
            }else{
                while(!heap.isEmpty() && heap.peek().height <= cur.height && heap.peek().start < cur.end){
                    if(heap.peek().end > cur.end){
                        Building next = heap.poll();
                        heap.add(new Building(cur.end, next.end, next.height));
                    }else{
                        heap.poll();
                    }
                }
                if(!heap.isEmpty()){
                    if(heap.peek().end < cur.end){
                        heap.add(new Building(heap.peek().end, cur.end, cur.height));
                    }
                    addResult(result, cur.start, heap.peek().start, cur.height);
                }else{
                    addResult(result, cur.start, cur.end, cur.height);
                }
            }
        }
        return result;
    }
    
    private static void addResult(ArrayList<ArrayList<Integer>> result, int start, int end, int height){
        if(start == end){
            return;
        }
        ArrayList<Integer> outline = new ArrayList<Integer>();
        outline.add(start);
        outline.add(end);
        outline.add(height);
        result.add(outline);
    }
    
    public static void main(String[] args){
    	int[][] buildings = {
    			{1,44,354},
    			{44,768,354},
    			{44, 45, 3}
    	};
        
    	ArrayList<ArrayList<Integer>> result = buildingOutline(buildings);
    	for(int i = 0; i < result.size(); i++){
    		System.out.println(result.get(i).get(0) + " " + result.get(i).get(1) + " " + result.get(i).get(2));
    	}
    }
}
