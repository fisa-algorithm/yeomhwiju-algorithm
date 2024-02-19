import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class bj_1026 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n =Integer.parseInt(br.readLine());
			
		
		String[] A = br.readLine().split(" ");
		String[] B = br.readLine().split(" ");

		Integer a[] = new Integer[n];		
		Integer b[] = new Integer[n];
		
		for(int i =0; i<n; i++) {
			a[i] = Integer.parseInt(A[i]);
			b[i] = Integer.parseInt(B[i]);
		}
	
		
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		
		int result = 0;
		for (int i = 0; i < n ; i++) {
			result = result + (Integer.parseInt(A[i]) * Integer.parseInt(B[i]));
		}
		
		System.out.println(result);
		
	}
	
}