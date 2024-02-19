import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bj_1946 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Map<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++){

			int n = Integer.parseInt(br.readLine());
			int result = 1;

			for (int i = 0; i < n; i++){

				String[] s = br.readLine().split(" ");
				map.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

			}

			List<Integer> keySet = new ArrayList<>(map.keySet());
			Collections.sort(keySet);

			//1번은 무조건 이기기 때문에 result도 1로 초기화
			int minNum = map.get(1);

			for (int i = 2; i <= n; i++){

				int targetNum = map.get(i);

				if (minNum > targetNum) {
					minNum = targetNum;
					result++;
				}
			}

			sb.append(result);
			sb.append("\n");
		}


		System.out.println(sb.toString());

	}
}
