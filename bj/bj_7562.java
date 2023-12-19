import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int dx[] = {2,2,1,-1,-2,-2,-1,1};
    static int dy[] = {1,-1,-2,-2,-1,1,2,2};
    static String[] startPosition; 
    
    static int targetX;
    static int targetY;
    
    static int[][] graph;
    static int[][] checkedGraph;
    
    static int result;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());

        
       
        for (int t=0; t < T; t++){
        	
            int l = Integer.parseInt(br.readLine());

            graph= new int[l][l];
            checkedGraph = new int[l][l];
            
            startPosition = br.readLine().split(" ");
            String[] targetPosition = br.readLine().split(" ");
            
            
            int startX = Integer.parseInt(startPosition[0]);
            int startY = Integer.parseInt(startPosition[1]);
            
            targetX = Integer.parseInt(targetPosition[0]);
            targetY = Integer.parseInt(targetPosition[1]);

            
            result = 0;
            bfs(startX, startY);
            
            System.out.println(checkedGraph[targetX][targetY]-1);
            System.out.println(checkedGraph[1][1]);
        }


    }
	
    private static void bfs(int x, int y) {
    	Queue<int[]> q = new LinkedList<>();
    	
		int[] xy = {x,y};
		checkedGraph[x][y] = 1;
		q.add(xy);
		
		while(!q.isEmpty()) {
			int[] nowXY = q.poll();
			int nowX = nowXY[0];
			int nowY = nowXY[1];

			
			if (nowX == targetX && nowY == targetY) {
				break;
			}
			
			
			for (int i = 0 ; i < 8 ; i++) {
				int nx = nowX + dx[i];				
				int ny = nowY + dy[i];
				
				if (nx >=0 && nx < graph.length && ny >= 0 && ny < graph.length && checkedGraph[nx][ny] == 0) {
					int[] nextXY = {nx, ny};
					q.add(nextXY);
					checkedGraph[nx][ny] = checkedGraph[nowX][nowY] + 1;

				}

			}
			
		}
				
	}


}