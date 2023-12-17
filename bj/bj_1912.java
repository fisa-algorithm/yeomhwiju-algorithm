package christmas.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class bj_1744 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");
        int result = 0;

        int[] dp = new int[n+1];

        dp[1]= Integer.parseInt(arr[0]);

        if (allNegative(arr)){
            result= Arrays.stream(arr).mapToInt(Integer::parseInt).max().orElse(0);
            System.out.println(result);
            return;
        }

        for (int i = 2; i <= n; i++){
            int now = dp[i-1] + Integer.parseInt(arr[i-1]);
            if(now >= 0){
                dp[i] = dp[i-1] + Integer.parseInt(arr[i-1]);
            } else {
                dp[i] = 0;
            }
        }

        result = Arrays.stream(dp).max().getAsInt();
        System.out.println(result);

    }

    private static boolean allNegative(String[] arr) {
        for (String num : arr) {
            int i = Integer.parseInt(num);
            if (i > 0){
                return false;
            }
        }
        return true;

    }


}
