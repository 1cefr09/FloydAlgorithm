
import java.util.*;

public class Prim {
    static final int INF = 9999;
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 3, 2, 4, INF, INF,INF},
                {3, 0, 4, INF, INF, INF,6},
                {2, 4, 0, INF, INF, 1,INF},
                {5, INF, INF, 0, 6, INF,INF},
                {INF, INF, INF, 5, 0, 3,INF},
                {INF, INF, 1, INF, 3, 0,2},
                {INF, 6, INF, INF, INF, 2,0}
        };

        boolean[] visited=new boolean[arr.length];
        visited[0]=true;
        PriorityQueue<Integer[]> queue=new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0]-o2[0];
            }
        });

        int count=1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[0][i]!=0&&!visited[i]){
                queue.add(new Integer[]{arr[0][i],0,i});
            }
        }
        while (count<arr.length){
            Integer[] temp=null;
            while (!queue.isEmpty()){
                temp=queue.poll();
                if(visited[temp[2]])continue;
                break;
            }
            visited[temp[2]]=true;
            System.out.println("起点："+temp[1]+" 终点："+temp[2]+"  长度为："+temp[0]);
            for (int i = 0; i < arr.length; i++) {
                if(arr[temp[2]][i]!=0&&!visited[i]){
                    queue.add(new Integer[]{arr[temp[2]][i],temp[2],i});
                }
            }
            count++;
        }
    }
}
