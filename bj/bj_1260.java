import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static boolean[] checked;
	static int[][] arr;

	static int n;
	static int m;
	static int v;
	static Queue<Integer> queue;
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][n + 1];
		checked = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) {
			checked[i] = true;
		}

		arr = extractGraph(m, arr);
		dfs(v);

		System.out.println();
		queue = new LinkedList<Integer>();
		checked = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			checked[i] = true;
		}
		bfs(v);

//		
//		bw.write(sb.toString());
//		bw.flush();
//		bw.close();

	}

	private static void bfs(int startNode) {

		queue.add(startNode);
		checked[startNode] = false;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.println(now + " ");

			for (int i = 1; i < n + 1; i++) {
				if (checked[i] && arr[now][i] == i) {
					queue.add(i);
					checked[i] = false;
				}

			}

		}
	}

	public static void dfs(int startNode) {
		checked[startNode] = false;
		System.out.print(startNode + " ");

		for (int i = 1; i < n + 1; i++) {
			if (checked[i] && arr[startNode][i] == i) {
				dfs(i);
			}

		}

	}

	public static int[][] extractGraph(int m, int[][] arr) throws IOException {

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = b;
			arr[b][a] = a;

		}

		return arr;
	}

}
