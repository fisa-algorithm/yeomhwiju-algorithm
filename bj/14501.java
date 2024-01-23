import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] cost = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) { 
            String[] split = br.readLine().split(" ");

            arr[i] = Integer.parseInt(split[0]);
            cost[i] = Integer.parseInt(split[1]);
        }

        for (int i = 1; i <= N; i++) { 

            dp[i] = Math.max(dp[i], dp[i - 1]);

            int finishDay = i + arr[i] - 1; 
            int intCost = cost[i];

            if (finishDay <= N) { 
                dp[finishDay] = Math.max(dp[finishDay], dp[i - 1] + intCost);
            }
        }

        System.out.println(dp[N]);

    }
}
