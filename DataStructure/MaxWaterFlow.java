package DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class WaterFlow{
	int start;
	int end;
	int amount;
	public WaterFlow(int s, int e, int a){
		this.start = s;
		this.end = e;
		this.amount = a;
	}
}

class MaxWaterFlow {	
	public static int getMaxWaterFlow(WaterFlow[] flows){
		Comparator<WaterFlow> startComparator = new Comparator<WaterFlow>(){
			@Override
			public int compare(WaterFlow o1, WaterFlow o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
			
		};
		Comparator<WaterFlow> endComparator = new Comparator<WaterFlow>(){
			@Override
			public int compare(WaterFlow o1, WaterFlow o2) {
				// TODO Auto-generated method stub
				return o1.end - o2.end;
			}
			
		};
		int result = 0;
		int current = 0;
		Queue<WaterFlow> heap1 = new PriorityQueue<WaterFlow>(flows.length, startComparator);
		Queue<WaterFlow> heap2 = new PriorityQueue<WaterFlow>(flows.length, endComparator);
		for(WaterFlow f : flows){
			heap1.add(f);
		}
		while(!heap1.isEmpty()){
			WaterFlow cur = heap1.poll();
			while(!heap2.isEmpty() && heap2.peek().end < cur.start){
				current -= heap2.poll().amount;
			}
			current += cur.amount;
			heap2.add(cur);
			result = Math.max(result, current);
		}
		return result;
	}
	
	public static void main(String[] args){
		WaterFlow[] flows = new WaterFlow[4];
		flows[0] = new WaterFlow(0, 10, 100);
		flows[1] = new WaterFlow(10, 15, 300);
		flows[2] = new WaterFlow(16, 20, 400);
		flows[3] = new WaterFlow(5, 15, 200);
		
		System.out.println(getMaxWaterFlow(flows));
	}
}
