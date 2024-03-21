import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1495 {

    static int n, s, m;
    static String[] volumes;
    static boolean[][] dp;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] nsm = br.readLine().split(" ");
        n = Integer.parseInt(nsm[0]);
        s = Integer.parseInt(nsm[1]);
        m = Integer.parseInt(nsm[2]);

        volumes = br.readLine().split(" ");
        dp = new boolean[n + 1][m + 1];

        // 시작 볼륨을 기준으로 설정
        dp[0][s] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j]) {
                    int minusValue = j - Integer.parseInt(volumes[i-1]);
                    int plusValue = j + Integer.parseInt(volumes[i-1]);

                    if (minusValue >= 0) {
                        dp[i][minusValue] = true;
                    }

                    if (plusValue <= m) {
                        dp[i][plusValue] = true;
                    }
                }
            }
        }

        //위에서 결과를 다 거르고 진행하기 때문에 마지막에 나오는 것이 정답일 수 밖에 없음
        // 혹 m보다 작은 값 0보다 큰 값만 넣는 경우를 말고 전부 넣어서도 정답을 구할 수 있음?
        int result = -1;
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
