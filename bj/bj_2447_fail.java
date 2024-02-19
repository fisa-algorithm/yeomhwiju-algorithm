import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_2447_fail {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static String[][] dfs(int n, int row, int colunm, String[][] array) {
		int num = array.length;

		if (n == 0) {
			return array;
		}
		int forNumber = Math.max((num / 3) / 3, 0); // 음수 방지를 위해 Math.max를 사용하여 양수로 조정

		for (int i = row; i < row + forNumber; i++) {
			for (int j = colunm; j < colunm + forNumber; j++) {
				array[i][j] = " ";
			}
		}

		for (int i = row; i < num; i += num / 3) {
			for (int j = colunm; j < num; j += num / 3) {
				dfs(n - 1, i, j, array);
			}
		}

		return array;

	}

	private static String[][] getArray(int n) {
		String[][] array = new String[n][n];

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				int nowRow = i % 3;
				int nowColunm = j % 3;

				if (nowRow == 1 && nowColunm == 1) {
					array[i][j] = " ";

				} else {
					array[i][j] = "*";
				}

			}
		}
		return array;
	}

	private static String[][] bigBlank(int startRow, int startColunm, String[][] array) {

		int num = array.length / 3;

		for (int i = startRow; i < startRow + num; i++) {

			for (int j = startColunm; j < num + startColunm; j++) {

				array[i][j] = " ";
			}
		}
		return array;
	}

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		String[][] array = getArray(n);

		int startPoint = array.length / 3;
		String[][] dfs = dfs((array.length / 3) / 3, startPoint / 3, startPoint / 3, array);

		String[][] result = bigBlank(startPoint, startPoint, dfs);

		for (String[] strings : result) {
			for (String str : strings) {
				sb.append(str);
			}
			sb.append("\n");
		}

		// sb를 BufferedWriter를 통해 한 번에 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); // BufferedWriter의 버퍼 비우기

		// BufferedReader와 BufferedWriter 닫기
		br.close();
		bw.close();
	}

}
