import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_30890 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static StringBuilder sb = new StringBuilder();
	static int x;
	static int y;

	public static void main(String[] args) throws IOException {

		String[] split = br.readLine().split(" ");

		x = Integer.parseInt(split[0]);
		y = Integer.parseInt(split[1]);

		int[] arr = new int[x * y + 1];

		for (int i = 1; i < arr.length; i++) {

			if (i % x == 0 && i % y == 0) {
				sb.append(3);
			} else if (i % x == 0) {
				sb.append(2);
			} else if (i % y == 0) {
				sb.append(1);
			}
		}

		System.out.println(sb.toString());

	}

}
