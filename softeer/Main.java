import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] arr;
	static int[][] dist;

	public static void main(String[] args) throws IOException {


		int n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		dist = new int[n][3];

		for (int i = 0; i < n; i++){
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < 3; j++){
				dist[i][j] = Integer.MAX_VALUE;
				arr[i][j] =Integer.parseInt(split[j]);

			}
		}


		dist[0][0] = 1;
		dist[0][1] = arr[0][1];
		dist[0][2] = 1;

		for (int i = 0; i < n; i++){

			for (int nowX = 0; nowX < 3; nowX++){
				// 마지막 계단 처리
				if (i+1 >= n){
					for (int lastX =0; lastX < 3; lastX++){
						if (arr[i][lastX] == 0){
							int abs = Math.abs(nowX - lastX);
							System.out.println(abs);
							dist[i][lastX] = Math.min(dist[i-1][nowX] +abs, dist[i][lastX]);
						}
					}
					break;
				}

				for (int j = 0; j < 3; j++){
					//현재 arr[i][nowX] 기준으로 3번 돌리고 이때 0일때만 내려갈 수 있게한다.
					if (arr[i+1][j] == 0) {
						int abs = Math.abs(nowX - j);
						dist[i + 1][j] = Math.min(dist[i + 1][j], dist[i][nowX]+abs);
					}
				}
			}
		}


		int result = 0;
		result = Math.min(dist[n-1][0] ,Math.min(dist[n-1][1], dist[n-1][2]));
		System.out.println(result);


	}

}