import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_2493 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int num = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");

		Stack<Top> stack = new Stack<>();
		int[] result = new int[num];

		for (int i = 0; i < num; i++) {

			Top now = new Top(i + 1, Integer.parseInt(arr[i]));

			while (!stack.isEmpty()) {
				if (now.getValue() < stack.peek().getValue()) {
					result[i] = stack.peek().getIndex();
					break;
				} else {
					stack.pop();
				}
			}

			//처음 시작에는 무조건 0을 출력할 수 있게 했다.
			if (stack.isEmpty()) {
				result[i] = 0;
			}
			stack.add(now);
		}

		StringBuilder sb = new StringBuilder();
		for (int n : result) {
			sb.append(n);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

	static class Top {
		private int index;
		private int value;

		public Top(int index, int value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return this.index;
		}

		public int getValue() {
			return this.value;
		}
	}
}
