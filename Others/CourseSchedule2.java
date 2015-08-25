package Others;
import java.util.*;

class CourseSchedule2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if(prerequisites == null || prerequisites.length == 0){
            for(int i = 0; i < numCourses; i++){
                result[i] = i;
            }
            return result;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int preq = prerequisites[i][1];
            int cur = prerequisites[i][0];
            if(!map.containsKey(preq)){
                map.put(preq, new ArrayList<Integer>());
            }
            map.get(preq).add(cur);
            System.out.println("preq = " + preq + " size = " + map.get(preq).size());
            indegree[cur]++;
        }
        print(indegree);
        int index = 0;
        while(index < numCourses){
        	int head = findNextHead(indegree);
        	if(head == -1){
        		return null;
        	}
            result[index] = head;
            for(int i = 0; map.containsKey(head) && i < map.get(head).size(); i++){
                int course = map.get(head).get(i);
                System.out.println("C = " + course);
                indegree[course]--;
            }
            index++;
            print(indegree);
        }
        return result;
    }
    
    private static int findNextHead(int[] indegree){
        int head = -1;
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                head = i;
                indegree[i]--;
                break;
            }
        }
        System.out.println("Head = " + head);
        return head;
    }
    
    private static void print(int[] A){
    	for(int i : A){
    		System.out.print(i + " ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args){
    	int[] result = findOrder(2, new int[][]{{1, 0}});
    	for(int i : result){
    		System.out.print(i + " ");
    	}
    }
}
