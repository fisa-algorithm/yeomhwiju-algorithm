import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class bj_1744 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new PriorityBlockingQueue<Integer>();
		Queue<Integer> negativeQueue = new PriorityBlockingQueue<Integer>();

		int result = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			// 1의 경우엔 양수에서 곱하기를 하는 경우보다 더해주는 경우가 무조건 값이 크기 때문에 1이 나오면 일단 result + 1을 해준다.
			if (num == 1) {
				result += 1;
			} else if (num <= 0) {
				negativeQueue.add(num);
			} else {
				queue.add(num);
			}
		}

		while (!queue.isEmpty()) {
			if (queue.size() == 1) {

				result += queue.remove();
			} else {
				result += queue.remove() * queue.remove();
			}
		}

		while (!negativeQueue.isEmpty()) {
			if (negativeQueue.size() == 1) {
				result += negativeQueue.remove();
			} else {
				result += negativeQueue.remove() * negativeQueue.remove();
			}

		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();

	}
}
