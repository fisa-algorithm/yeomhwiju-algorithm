import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String board;
	static int xCount;
	static int dotCount;

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		board = st.nextToken();

		xCount = extractedCharCount('X');
		dotCount = extractedCharCount('.');

		// 1차적으로 2로 나누어지지 않는 x의 개수라면 애초에 덮을 수 없어서 -1 출력후 종료
		if (xCount % 2 != 0) {
			System.out.println(-1);
			return;
		} else if (dotCount == board.length()) {

			System.out.println(".".repeat(board.length()));
			return;

		}

		int pointerIndex = 0;
		int localXCounte = 0;

		while (pointerIndex < board.length()) {

			if (board.charAt(pointerIndex) != '.') {
				localXCounte += 1;

			} else if (board.charAt(pointerIndex) == '.') {

				if (localXCounte != 0) {
					int share = localXCounte / 4;
					int remainder = localXCounte % 4;

					if (remainder % 2 == 1) {
						System.out.println(-1);
						return;
					}
					sb.append("AAAA".repeat(share));
					if (remainder == 2) {
						sb.append("BB");
					}
				}

				sb.append(".");
				localXCounte = 0;
			}
			pointerIndex += 1;
		}

		if (localXCounte != 0) {
			int share = localXCounte / 4;
			int remainder = localXCounte % 4;

			sb.append("AAAA".repeat(share));
			if (remainder == 2) {
				sb.append("BB");
			}
		}

		System.out.println(sb.toString());

	}

	private static int extractedCharCount(char c) {
		int cnt = 0;
		for (int i = 0; i < board.length(); i++) {
			if (board.charAt(i) == c) {
				cnt += 1;
			}

		}
		return cnt;
	}

}
