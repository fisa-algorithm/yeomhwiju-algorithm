import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bj_2110 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int c;
	static int result;


	public static void main(String[] args) throws IOException {

		String[] split = br.readLine().split(" ");

		ArrayList<Integer> arr = new ArrayList<Integer>();

		n = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr.add(num);
		}

		Collections.sort(arr);
		int[] house = (int[])arr.stream().mapToInt(Integer::intValue).toArray();

		int start = 1;
		int end = 1000000000;
		int result = 0;


		while (start <= end){

			int mid = (start + end) / 2;
			int cnt = 0;
			int pre = -1000000000;
			for(int i = 0; i < n; i++){
				if (arr.get(i) - pre >= mid){
					cnt ++;
					pre = arr.get(i);
				}
			}

			if (cnt >= c){
				result = Math.max(result, mid);
				start = mid+1;
			} else {
				end = mid-1;
			}
		}

		System.out.println(result);

	}


}
