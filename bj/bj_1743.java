import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1743 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    static int k;

    static int cnt;

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        String[] split = s.split(" ");
        n = Integer.parseInt(split[0]);//세로
        m = Integer.parseInt(split[1]);//가로
        k = Integer.parseInt(split[2]);//음쓰 숫자

        graph = new int[n][m];

        for (int i = 0; i < k ; i++){
            String trash = br.readLine();
            String[] trashSplit = trash.split(" ");

            int row = Integer.parseInt(trashSplit[0]);
            int column = Integer.parseInt(trashSplit[1]);
            graph[row-1][column-1] = 1;
        }

        int result =0;
        for (int i = 0; i< n; i++){
            for (int j = 0; j < m; j++){
                if(graph[i][j] == 1){
                    cnt =0;
                    dfs(i, j);
                    result = Math.max(result, cnt);
                }
            }
        }

        System.out.println(result);
    }

    private static void dfs(int x, int y) {
        graph[x][y] = 0;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && graph[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
