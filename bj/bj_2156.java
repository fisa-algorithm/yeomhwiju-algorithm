import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class bj_2156{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int n;
    
    public static void main(String[] args) throws IOException {
    	
    	n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n];
    	int[] dp = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		int n = Integer.parseInt(br.readLine());
    		arr[i]=n;
    	}
    	
    	dp[0] = arr[0];
    	
    	if(n >= 2) {
    		dp[1] = arr[0]+arr[1];
    	} 
    	   	
    	// 3의 경우? 
    	if (n >= 3) {
    		dp[2] = Math.max(arr[0]+arr[2], arr[2]+arr[1]);
    		
 
    	}
    	
    	for(int i=3; i < n ; i++) {
			dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
		}
		    	
    	int result = Arrays.stream(dp).max().getAsInt();
    	System.out.println(result);
    
    }

	
	
	
}
	
  

