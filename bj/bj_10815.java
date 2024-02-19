import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class bj_10815 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;

	private static List<Integer> getResult() throws IOException {

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		List<Integer> nList = getList();

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		List<Integer> mList = getList();

		Map<Integer, Boolean> checkedList = new HashMap<>();

		for (Integer no : nList) {
			checkedList.put(no, true);
		}

		return extractResult(mList, checkedList);

	}

	private static List<Integer> extractResult(List<Integer> nList, Map<Integer, Boolean> checkedList) {

		List<Integer> result = new ArrayList<>();

		for (int no : nList) {

			if (!Objects.isNull(checkedList.get(no)) && Objects.requireNonNull(checkedList.get(no))) {
				result.add(1);

			} else {

				result.add(0);

			}
		}
		return result;
	}

	private static List<Integer> getList() throws IOException {
		List<Integer> list = new ArrayList<Integer>();

		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			int addNum = Integer.parseInt(st.nextToken());

			list.add(addNum);
		}

		return list;
	}

	public static void main(String[] args) throws IOException {

		List<Integer> result = getResult();
		for (Integer integer : result) {

			sb.append(integer).append(" ");

		}

		System.out.println(sb.toString().trim());

	}

}
