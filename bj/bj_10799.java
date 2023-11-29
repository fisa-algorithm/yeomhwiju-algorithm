import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		System.out.println(getResult());

	}

	private static int getResult() throws IOException {

		st = new StringTokenizer(br.readLine());

		String nextToken = st.nextToken();
		nextToken = nextToken.trim();

		Stack<String> stack = new Stack<>();

		int result = 0;

		for (int i = 0; i < nextToken.length(); i++) {

			if (nextToken.charAt(i) == '(') {

				stack.add(String.valueOf(nextToken.charAt(i)));

			}

			else {
				
				stack.pop();
				if (nextToken.charAt(i-1) == '(') {
					result += stack.size();

				} else {

					result++;
				}
			}

		}

		return result;
	}

}


/*
 * 1. 쇠막대기 여는 괄호를 처리할 것을 고려하자
 * 2. 닫는 괄호일 때 바로 직전 괄호가 여는 괄호인지 닫는 괄호인지를 고려하자
 *  - 이를 고려해야 닫는 괄호 바로 직전 여는 괄호일 때 레이저인지를 판별 + stack.size()
 *  - 또 다른 부분으로는 닫는 괄호에 바로 직전 괄호가 닫는 괄호일 땐 쇠막대기의 끝부분인지를 판별 +1 
 * 3. 쇠막대기의 바로 직전 괄호가 닫는 괄호인지 여는 괄호인지를 고려하자
 * 4. 레이저 부분에서는 기존 쌓인 스택 사이즈를 더해준다.
 * 5. 막대기의 끝에서는 +1만 더해주는 작업 진행
 */