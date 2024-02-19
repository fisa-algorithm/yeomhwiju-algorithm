import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1158 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;

	private static String getResult() throws IOException {

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> josephus = getJosephus(n);

		List<String> result = new ArrayList<>();

		while (josephus.size() != 0) {
			for (int i = 0; i < k - 1; i++) {

				josephus.add(josephus.remove());

			}
			result.add(String.valueOf(josephus.remove()));

		}

		String string = getResultToString(result);

		return sb.append("<" + string + ">").toString();
	}

	private static String getResultToString(List<String> result) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			stringBuilder.append(result.get(i));
			if (i != result.size() - 1) {
				stringBuilder.append(", ");
			}
		}
		return stringBuilder.toString();
	}

	private static Queue<Integer> getJosephus(int n) {

		Queue<Integer> josephus = new LinkedList();

		for (int i = 0; i < n; i++) {
			josephus.add(i + 1);
		}

		return josephus;
	}

	public static void main(String[] args) throws IOException {

		System.out.println(getResult());

	}

}
