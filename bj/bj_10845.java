import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static List<Integer> queue = new ArrayList<Integer>();

	private static void push(int num) {
		queue.add(num);

	}

	private static void pop() {

		if (queue.isEmpty()) {

			System.out.println(-1);
			return;

		}
		System.out.println(queue.remove(0));

	}

	private static void size() {

		System.out.println(queue.size());

	}

	private static void empty() {

		if (queue.isEmpty()) {

			System.out.println(1);
			return;

		}
		System.out.println(0);

	}

	private static void front() {

		if (queue.isEmpty()) {
			System.out.println(-1);
			return;
		}

		System.out.println(queue.get(0));

	}

	private static void back() {

		if (queue.isEmpty()) {
			System.out.println(-1);
			return;
		}

		int lastIndex = queue.size() - 1;
		System.out.println(queue.get(lastIndex));

	}

	private static void getResult() throws IOException {

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();

			if (command.equals("push")) {

				int num = Integer.parseInt(st.nextToken());

				push(num);

			} else if (command.equals("pop")) {

				pop();

			} else if (command.equals("size")) {

				size();

			} else if (command.equals("empty")) {

				empty();

			} else if (command.equals("front")) {

				front();
			} else {

				back();

			}

		}
	}

	public static void main(String[] args) throws IOException {

		getResult();

	}

}
