import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Map<String, String> map = new HashMap<>();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++){
			int n = Integer.parseInt(br.readLine());
			int result = n;
			for (int i = 0; i < n; i++){

				String[] s = br.readLine().split(" ");
				map.put(s[0], s[1]);

			}

			List<String> keySet = new ArrayList<>(map.keySet());
			Collections.sort(keySet);

			int pointer = 1;

			while (pointer >= n){

				int start = Integer.parseInt(map.get(pointer));
				int end = Integer.parseInt(map.get(pointer + 1));

				if (start < end){
					result -= 1;
				}

				pointer += 1;

			}

			System.out.println(result);
		}



	}
}
